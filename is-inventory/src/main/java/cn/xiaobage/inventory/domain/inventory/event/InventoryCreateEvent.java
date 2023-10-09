package cn.xiaobage.inventory.domain.inventory.event;

import cn.hutool.core.util.IdUtil;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.infrastructure.common.event.DomainEvent;
import com.alibaba.fastjson.JSON;

import java.util.Date;

public class InventoryEvent extends DomainEvent {

    public static InventoryEvent create(Inventory inventory){
        InventoryEvent event = new InventoryEvent();
        event.setId(IdUtil.getSnowflakeNextId());
        event.setServerName("is-inventory");
        event.setClassName(inventory.getClass().getName());
        event.setTime(new Date());
        event.setData(JSON.toJSONString(inventory));
        return event;
    }
}
