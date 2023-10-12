package cn.xiaobage.inventory.infrastructure.common.event.listener;

import cn.xiaobage.inventory.domain.inventory.event.InventoryCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(0)
@Component
public class InventoryCreateEventListener{

    @EventListener
    public void onApplicationEvent(InventoryCreateEvent inventoryCreateEvent) {
        log.info("inventoryCreateEvent:==>{}",inventoryCreateEvent);
    }
}
