package cn.xiaobage.inventory.infrastructure.common.redis;

import cn.hutool.json.JSONObject;
import cn.xiaobage.config.util.FileLoad;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Slf4j
@Component
public class RedisOpsInventory {

    @Autowired
    RedisTemplate redisTemplate;

    private static String inventoryDeductionLua;

    private static String inventoryIncrementLua;

    static {
        inventoryDeductionLua = FileLoad.read("lua/inventory_deduction.lua");
        inventoryIncrementLua = FileLoad.read("lua/inventory_increment.lua");
    }

    public Inventory  saveInventory(Inventory inventory){
        JSONObject jsonObject = new JSONObject(inventory);
        redisTemplate.opsForHash().putAll(RedisKeyPrefixConst.InventoryCache+inventory.getId(),jsonObject);
        return inventory;
    }

    public Long  invokeIncrementLua(WarehouseInRecord warehouseInRecord){
        RedisScript<Long> redisScript = new DefaultRedisScript(inventoryIncrementLua,Long.class);
        Long inventoryId = (Long) redisTemplate.execute(redisScript, Arrays.asList(RedisKeyPrefixConst.InventoryCache + warehouseInRecord.getInventoryId(),Inventory.TOTAL_QUANTITY_FIELD_NAME,Inventory.UPDATE_TIME_FIELD_NAME),warehouseInRecord.getQuantity(),warehouseInRecord.getCreateTime());
        return inventoryId;
    }

    public Long  invokeInventoryDeductionLua(OutboundDeliveryOrder outboundDeliveryOrder){
        RedisScript<Long> redisScript = new DefaultRedisScript(inventoryDeductionLua,Long.class);
        Long inventoryId = (Long) redisTemplate.execute(redisScript, Arrays.asList(RedisKeyPrefixConst.InventoryCache + outboundDeliveryOrder.getInventoryId(),Inventory.TOTAL_QUANTITY_FIELD_NAME,Inventory.UPDATE_TIME_FIELD_NAME),outboundDeliveryOrder.getQuantity(),outboundDeliveryOrder.getCreateTime());
        return inventoryId;
    }
}
