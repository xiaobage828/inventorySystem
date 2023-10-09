package cn.xiaobage.inventory.interfaces.facade;

import cn.xiaobage.inventory.domain.inventory.event.OutboundDeliveryOrderCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(topic = "outboundDeliveryOrder-create", consumerGroup = "decr-inventory-group")
public class OutboundDeliveryOrderCreateMQListener implements RocketMQListener<OutboundDeliveryOrderCreateEvent> {

    @Override
    public void onMessage(OutboundDeliveryOrderCreateEvent message) {
        log.info("接收到MQ消息 {}", message);
    }

}
