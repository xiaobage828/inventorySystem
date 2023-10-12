package cn.xiaobage.warning.infrastructure.common.event.listener;

import cn.xiaobage.warning.domain.warning.event.WarningRecordCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(1)
@Component
public class WarningRecordCreateEventMQPublisher {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @EventListener
    public void onApplicationEvent(WarningRecordCreateEvent warningRecordCreateEvent) {
        rocketMQTemplate.convertAndSend("warning-record-create",warningRecordCreateEvent);
    }
}
