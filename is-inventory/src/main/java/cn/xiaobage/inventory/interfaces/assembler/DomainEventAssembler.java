package cn.xiaobage.inventory.interfaces.assembler;

import cn.xiaobage.common.event.DomainEvent;
import cn.xiaobage.inventory.interfaces.dto.DomainEventDTO;

public class DomainEventAssembler {

    public static DomainEventDTO toDTO(DomainEvent domainEvent){
        DomainEventDTO dto = new DomainEventDTO();
        dto.setId(domainEvent.getId());
        dto.setData(domainEvent.getData());
        dto.setClassName(domainEvent.getClassName());
        dto.setServerName(domainEvent.getServerName());
        dto.setTime(domainEvent.getTime());
        return dto;
    }
}
