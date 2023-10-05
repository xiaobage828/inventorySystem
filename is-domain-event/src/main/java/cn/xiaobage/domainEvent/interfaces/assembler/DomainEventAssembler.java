package cn.xiaobage.domainEvent.interfaces.assembler;

import cn.xiaobage.domainEvent.domain.domainEvent.entity.DomainEvent;
import cn.xiaobage.domainEvent.interfaces.dto.DomainEventDTO;

public class DomainEventAssembler {

    public static DomainEvent toDO(DomainEventDTO dto){
        DomainEvent event = new DomainEvent();
        event.setId(dto.getId());
        event.setTime(dto.getTime());
        event.setData(dto.getData());
        event.setServerName(dto.getServerName());
        event.setClassName(dto.getClassName());
        return event;
    }
}
