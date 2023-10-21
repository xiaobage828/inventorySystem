package cn.xiaobage.inventory.infrastructure.common.redis;

import cn.xiaobage.config.util.FileLoad;
import cn.xiaobage.config.util.RedisUtil;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisOpsInventory {


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private static String inventoryQueryLua;

    private static String inventoryDeductionLua;

    private static String inventoryIncrementLua;

    static {
        inventoryQueryLua = FileLoad.read("lua/inventory_query.lua");
        inventoryDeductionLua = FileLoad.read("lua/inventory_deduction.lua");
        inventoryIncrementLua = FileLoad.read("lua/inventory_increment.lua");
    }

    public Inventory  saveInventory(Inventory inventory){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        objectMapper.registerModules(new JavaTimeModule(), new Jdk8Module());
        Map<String,String> map = objectMapper.convertValue(inventory,new TypeReference<Map<String,String>>(){});
        stringRedisTemplate.opsForHash().putAll(RedisKeyPrefixConst.InventoryCache+inventory.getId(), map);
        return inventory;
    }

    public Inventory  saveEmptyInventory(Long inventoryId, Inventory inventory){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        objectMapper.registerModules(new JavaTimeModule(), new Jdk8Module());
        Map<String,String> map = objectMapper.convertValue(inventory,new TypeReference<Map<String,String>>(){});
        stringRedisTemplate.opsForHash().putAll(RedisKeyPrefixConst.InventoryCache + inventoryId, map);
        return new Inventory();
    }

    public Inventory queryInventoryByIdFromCache(Long inventoryId){
        if(! stringRedisTemplate.hasKey(RedisKeyPrefixConst.InventoryCache + inventoryId ))
            return null;
        RedisScript<String> redisScript = new DefaultRedisScript(inventoryQueryLua,String.class);
        String inventoryJSONString =  stringRedisTemplate.execute(redisScript, Arrays.asList(RedisKeyPrefixConst.InventoryCache + inventoryId));
        Inventory inventory =  JSONObject.parseObject(inventoryJSONString,Inventory.class);
        if(Inventory.NULL_INVENTORY.equals(inventory)){
            stringRedisTemplate.expire(RedisKeyPrefixConst.InventoryCache + inventoryId , RedisUtil.getEmptyTimeOut(), TimeUnit.SECONDS);
            return new Inventory();
        }
        return inventory;
    }

    public Inventory invokeIncrementLua(WarehouseInRecord warehouseInRecord){
        RedisScript<String> redisScript = new DefaultRedisScript(inventoryIncrementLua,String.class);
        String inventory =  stringRedisTemplate.execute(redisScript, Arrays.asList(RedisKeyPrefixConst.InventoryCache + warehouseInRecord.getInventoryId(),Inventory.TOTAL_QUANTITY_FIELD_NAME,Inventory.UPDATE_TIME_FIELD_NAME),warehouseInRecord.getQuantity().toString(), DateFormatUtils.format(warehouseInRecord.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
        return JSONObject.parseObject(inventory,Inventory.class);
    }

    public Inventory  invokeInventoryDeductionLua(OutboundDeliveryOrder outboundDeliveryOrder){
        RedisScript<String> redisScript = new DefaultRedisScript(inventoryDeductionLua,String.class);
        String inventory =  stringRedisTemplate.execute(redisScript, Arrays.asList(RedisKeyPrefixConst.InventoryCache + outboundDeliveryOrder.getInventoryId(),Inventory.TOTAL_QUANTITY_FIELD_NAME,Inventory.UPDATE_TIME_FIELD_NAME),outboundDeliveryOrder.getQuantity().toString(),DateFormatUtils.format(outboundDeliveryOrder.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
        return JSONObject.parseObject(inventory,Inventory.class);
    }

}
