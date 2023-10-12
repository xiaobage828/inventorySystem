package cn.xiaobage.warning.interfaces.facade;

import cn.xiaobage.warning.application.service.WarningRecordApplicationService;
import cn.xiaobage.warning.domain.warning.entity.Inventory;
import cn.xiaobage.warning.domain.warning.event.InventoryUpdateEvent;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(topic = "inventory-update", consumerGroup = "trigger-inventory-waring")
public class InventoryUpdateEventMQListener implements RocketMQListener<InventoryUpdateEvent> {

    @Autowired
    WarningRecordApplicationService warningRecordApplicationService;

    @Override
    public void onMessage(InventoryUpdateEvent message) {
        log.info("接收到MQ消息 {}", message);
        Inventory inventory = JSONObject.parseObject(message.getData(),Inventory.class);
        warningRecordApplicationService.triggerInventoryWarningIfNecessary(inventory.getId(), inventory.getTotalQuantity());
    }

}
