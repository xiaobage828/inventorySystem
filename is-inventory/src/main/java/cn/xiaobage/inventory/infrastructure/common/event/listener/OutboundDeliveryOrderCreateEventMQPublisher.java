package cn.xiaobage.inventory.infrastructure.common.event.listener;

import cn.xiaobage.inventory.domain.inventory.event.OutboundDeliveryOrderCreateEvent;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class OutboundDeliveryOrderCreateEventMQPublisher {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @EventListener
    public void onApplicationEvent(OutboundDeliveryOrderCreateEvent outboundDeliveryOrderCreateEvent) {
        rocketMQTemplate.convertAndSend("outboundDeliveryOrder-create",outboundDeliveryOrderCreateEvent);
    }
}
