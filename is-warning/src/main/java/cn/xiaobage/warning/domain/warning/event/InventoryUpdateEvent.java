package cn.xiaobage.inventory.domain.inventory.event;

import cn.hutool.core.util.IdUtil;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.infrastructure.common.event.DomainEvent;
import com.alibaba.fastjson.JSON;

import java.util.Date;

public class InventoryUpdateEvent extends DomainEvent {

    public static InventoryUpdateEvent create(Inventory inventory){
        InventoryUpdateEvent event = new InventoryUpdateEvent();
        event.setId(IdUtil.getSnowflakeNextId());
        event.setServerName("is-inventory");
        event.setClassName(inventory.getClass().getName());
        event.setTime(new Date());
        event.setData(JSON.toJSONString(inventory));
        return event;
    }
}
