package cn.xiaobage.inventory.domain.inventory.event;

import cn.hutool.core.util.IdUtil;
import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import cn.xiaobage.inventory.infrastructure.common.event.DomainEvent;
import com.alibaba.fastjson.JSON;

import java.util.Date;

public class WarehouseInRecordCreateEvent extends DomainEvent {

    public static WarehouseInRecordCreateEvent create(WarehouseInRecord warehouseInRecord){
        WarehouseInRecordCreateEvent event = new WarehouseInRecordCreateEvent();
        event.setId(IdUtil.getSnowflakeNextId());
        event.setServerName("is-inventory");
        event.setClassName(warehouseInRecord.getClass().getName());
        event.setTime(new Date());
        event.setData(JSON.toJSONString(warehouseInRecord));
        return event;
    }
}
