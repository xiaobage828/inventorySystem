package cn.xiaobage.inventory.infrastructure.common.event.listener;

import cn.xiaobage.inventory.domain.inventory.event.WarehouseInRecordCreateEvent;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class WarehouseInRecordCreateEventMQPublisher {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @EventListener
    public void onApplicationEvent(WarehouseInRecordCreateEvent warehouseInRecordCreateEvent) {
        rocketMQTemplate.convertAndSend("warehouse-in-record-create",warehouseInRecordCreateEvent);
    }
}
