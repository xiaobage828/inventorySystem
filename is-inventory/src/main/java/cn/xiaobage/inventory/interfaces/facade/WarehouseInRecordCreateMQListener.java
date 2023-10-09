package cn.xiaobage.inventory.interfaces.facade;

import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(topic = "outboundDeliveryOrder-create", consumerGroup = "incr-inventory-group")
public class OutboundDeliveryOrderCreateMQListener implements RocketMQListener<OutboundDeliveryOrder> {

    @Override
    public void onMessage(OutboundDeliveryOrder message) {
        log.info("接收到MQ消息 {}", message);
    }

}
