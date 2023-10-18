package cn.xiaobage.inventory.infrastructure.common.action.impl;

import cn.xiaobage.common.util.ResultHolder;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.infrastructure.common.action.InventoryCreateTccAction;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisKeyPrefixConst;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class InventoryCreateTccActionImpl implements InventoryCreateTccAction {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Override
    public boolean prepareInventoryCreate(BusinessActionContext businessActionContext, Long inventoryId, Inventory inventory) {

        log.info("创建 inventory 第一阶段，预留资源 - " + businessActionContext.getXid());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModules(new JavaTimeModule(), new Jdk8Module());
        Map<String,String> map = objectMapper.convertValue(inventory,new TypeReference<Map<String,String>>(){});
        map.put("tccActionStatus","0");

        stringRedisTemplate.opsForHash().putAll(RedisKeyPrefixConst.InventoryCache + inventory.getId(), map);

        //事务成功，保存一个标识，供第二阶段进行判断
        ResultHolder.setResult(getClass(), businessActionContext.getXid(), "p");

        return true;
    }

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {

        log.info("创建 inventory 第二阶段回滚，修改inventory状态 - " + businessActionContext.getXid());

        // 防止幂等性，如果commit阶段重复执行则直接返回
        if (ResultHolder.getResult(getClass(), businessActionContext.getXid()) == null) {
            return true;
        }

        stringRedisTemplate.opsForHash().put(RedisKeyPrefixConst.InventoryCache + businessActionContext.getActionContext("inventoryId"),"tccActionStatus","1");

        //提交成功是删除标识
        ResultHolder.removeResult(getClass(), businessActionContext.getXid());

        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {

        log.info("创建 inventory 第二阶段回滚，删除inventory - " + businessActionContext.getXid());

        //第一阶段没有完成的情况下，不必执行回滚（空回滚处理）
        //因为第一阶段有本地事务，事务失败时已经进行了回滚。
        //如果这里第一阶段成功，而其他全局事务参与者失败，这里会执行回滚
        //幂等性控制：如果重复执行回滚则直接返回
        if (ResultHolder.getResult(getClass(), businessActionContext.getXid()) == null) {
            return true;
        }

        stringRedisTemplate.delete(RedisKeyPrefixConst.InventoryCache + businessActionContext.getActionContext("inventoryId"));

        //回滚结束时，删除标识
        ResultHolder.removeResult(getClass(), businessActionContext.getXid());

        return true;
    }
}
