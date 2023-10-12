package cn.xiaobage.warning.domain.warning.event;

import cn.hutool.core.util.IdUtil;
import cn.xiaobage.common.event.DomainEvent;
import cn.xiaobage.warning.domain.warning.entity.WarningRecord;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class WarningRecordCreateEvent extends DomainEvent {

    public static WarningRecordCreateEvent create(WarningRecord warningRecord){
        WarningRecordCreateEvent warningRecordCreateEvent = new WarningRecordCreateEvent();
        warningRecordCreateEvent.setId(IdUtil.getSnowflakeNextId());
        warningRecordCreateEvent.setTime(new Date());
        warningRecordCreateEvent.setData(JSONObject.toJSONString(warningRecord));
        warningRecordCreateEvent.setServerName("is-warning");
        warningRecordCreateEvent.setClassName(warningRecord.getClass().getName());
        return warningRecordCreateEvent;
    }
}
