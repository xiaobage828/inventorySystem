package cn.xiaobage.warning.interfaces.facade;

import cn.xiaobage.common.annotation.RedissonDistributedLock;
import cn.xiaobage.config.redisson.rLock.RLockType;
import cn.xiaobage.warning.domain.warning.event.WarningRecordCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = "warning-record-create", consumerGroup = "process-warning-record")
public class WarningRecordCreateEventMQListener implements RocketMQListener<WarningRecordCreateEvent> {

    @RedissonDistributedLock(redissonClient = "redisson",rlockType = RLockType.REDISSON_WRITE_LOCK,keyPrefix = "lock:domain_event:warning_record_create:",key="#message.id")
    @Override
    public void onMessage(WarningRecordCreateEvent message) {
        log.info("接收到MQ消息 {}",message);
    }
}
