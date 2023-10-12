package cn.xiaobage.inventory.infrastructure.common.redis;

import cn.xiaobage.config.util.FileLoad;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Slf4j
@Component
public class RedisOpsInventory {


    @Autowired
    StringRedisTemplate stringRedisTemplate;


    private static String inventoryDeductionLua;

    private static String inventoryIncrementLua;

    static {
        inventoryDeductionLua = FileLoad.read("lua/inventory_deduction.lua");
        inventoryIncrementLua = FileLoad.read("lua/inventory_increment.lua");
    }

    public Inventory  saveInventory(Inventory inventory){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModules(new JavaTimeModule(), new Jdk8Module());
        Map<String,String> map = objectMapper.convertValue(inventory,new TypeReference<Map<String,String>>(){});
        stringRedisTemplate.opsForHash().putAll(RedisKeyPrefixConst.InventoryCache+inventory.getId(), map);
        return inventory;
    }

    public Inventory invokeIncrementLua(WarehouseInRecord warehouseInRecord){
        RedisScript<String> redisScript = new DefaultRedisScript(inventoryIncrementLua,String.class);
        String inventory =  stringRedisTemplate.execute(redisScript, Arrays.asList(RedisKeyPrefixConst.InventoryCache + warehouseInRecord.getInventoryId(),Inventory.TOTAL_QUANTITY_FIELD_NAME,Inventory.UPDATE_TIME_FIELD_NAME),warehouseInRecord.getQuantity().toString(),warehouseInRecord.getCreateTime().toString());
        return JSONObject.parseObject(inventory,Inventory.class);
    }

    public Inventory  invokeInventoryDeductionLua(OutboundDeliveryOrder outboundDeliveryOrder){
        RedisScript<String> redisScript = new DefaultRedisScript(inventoryDeductionLua,String.class);
        String inventory =  stringRedisTemplate.execute(redisScript, Arrays.asList(RedisKeyPrefixConst.InventoryCache + outboundDeliveryOrder.getInventoryId(),Inventory.TOTAL_QUANTITY_FIELD_NAME,Inventory.UPDATE_TIME_FIELD_NAME),outboundDeliveryOrder.getQuantity().toString(),outboundDeliveryOrder.getCreateTime().toString());
        return JSONObject.parseObject(inventory,Inventory.class);
    }

}
