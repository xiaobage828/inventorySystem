package cn.xiaobage.inventory.interfaces.facade;

import cn.xiaobage.common.annotation.RedissonDistributedLock;
import cn.xiaobage.config.redisson.rLock.RLockType;
import cn.xiaobage.inventory.application.service.InventoryApplicationService;
import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import cn.xiaobage.inventory.domain.inventory.event.WarehouseInRecordCreateEvent;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(topic = "warehouse-in-record-create", consumerGroup = "incr-inventory-group")
public class WarehouseInRecordCreateMQListener implements RocketMQListener<WarehouseInRecordCreateEvent> {

    @Autowired
    InventoryApplicationService inventoryApplicationService;

    @RedissonDistributedLock(redissonClient = "redisson",rlockType = RLockType.REDISSON_WRITE_LOCK,keyPrefix = "lock:domain_event:warehouse_in_record_create:",key="#message.id")
    @Override
    public void onMessage(WarehouseInRecordCreateEvent message) {
        log.info("接收到MQ消息 {}", message);
        WarehouseInRecord warehouseInRecord = JSONObject.parseObject(message.getData(), WarehouseInRecord.class);
        inventoryApplicationService.inventoryIncrement(warehouseInRecord.getInventoryId(), warehouseInRecord.getQuantity(), warehouseInRecord.getCreateTime());
    }

}
