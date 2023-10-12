package cn.xiaobage.inventory.interfaces.facade;

import cn.xiaobage.inventory.application.service.InventoryApplicationService;
import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.domain.inventory.event.OutboundDeliveryOrderCreateEvent;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(topic = "outbound-delivery-order-create", consumerGroup = "decr-inventory-group")
public class OutboundDeliveryOrderCreateMQListener implements RocketMQListener<OutboundDeliveryOrderCreateEvent> {

    @Autowired
    InventoryApplicationService inventoryApplicationService;

    @Override
    public void onMessage(OutboundDeliveryOrderCreateEvent message) {
        log.info("接收到MQ消息 {}", message);
        OutboundDeliveryOrder outboundDeliveryOrder = JSONObject.parseObject(message.getData(),OutboundDeliveryOrder.class);
        inventoryApplicationService.inventoryDecrement(outboundDeliveryOrder.getInventoryId(), outboundDeliveryOrder.getQuantity(), outboundDeliveryOrder.getCreateTime());
    }

}
