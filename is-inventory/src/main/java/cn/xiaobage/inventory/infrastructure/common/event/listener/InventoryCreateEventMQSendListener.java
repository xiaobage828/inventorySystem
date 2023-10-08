package cn.xiaobage.inventory.infrastructure.common.event.listener;

import cn.xiaobage.inventory.domain.inventory.event.InventoryCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(1)
@Component
public class InventoryCreateEventMQSendListener {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @EventListener
    public void onApplicationEvent(InventoryCreateEvent inventoryCreateEvent) {
        rocketMQTemplate.convertAndSend("inventory-create",inventoryCreateEvent);
    }
}
