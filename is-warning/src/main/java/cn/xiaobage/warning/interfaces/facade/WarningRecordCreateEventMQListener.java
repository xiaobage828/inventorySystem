package cn.xiaobage.warning.interfaces.facade;

import cn.xiaobage.warning.domain.warning.event.WarningRecordCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = "warning-record-create", consumerGroup = "process-warning-record")
public class WarningRecordCreateEventMQListener implements RocketMQListener<WarningRecordCreateEvent> {

    @Override
    public void onMessage(WarningRecordCreateEvent message) {
        log.info("接收到MQ消息 {}",message);
    }
}
