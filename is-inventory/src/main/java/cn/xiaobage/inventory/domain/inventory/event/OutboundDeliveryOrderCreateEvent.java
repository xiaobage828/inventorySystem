package cn.xiaobage.inventory.domain.inventory.event;

import cn.hutool.core.util.IdUtil;
import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.common.event.DomainEvent;
import com.alibaba.fastjson.JSON;

import java.util.Date;

public class OutboundDeliveryOrderCreateEvent extends DomainEvent {

    public static OutboundDeliveryOrderCreateEvent create(OutboundDeliveryOrder outboundDeliveryOrder){
        OutboundDeliveryOrderCreateEvent event = new OutboundDeliveryOrderCreateEvent();
        event.setId(IdUtil.getSnowflakeNextId());
        event.setServerName("is-inventory");
        event.setClassName(outboundDeliveryOrder.getClass().getName());
        event.setTime(new Date());
        event.setData(JSON.toJSONString(outboundDeliveryOrder));
        return event;
    }
}
