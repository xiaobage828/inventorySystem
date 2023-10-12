package cn.xiaobage.domainEvent.domain.domainEvent.service;

import cn.xiaobage.domainEvent.domain.domainEvent.entity.DomainEvent;
import cn.xiaobage.domainEvent.domain.domainEvent.repository.po.DomainEventPO;
import org.springframework.stereotype.Service;

@Service
public class DomainEventFactory {

    public DomainEventPO createDomainEventPO(DomainEvent domainEvent){
        DomainEventPO eventPO = new DomainEventPO();
        eventPO.setId(domainEvent.getId());
        eventPO.setTime(domainEvent.getTime());
        eventPO.setData(domainEvent.getData());
        eventPO.setServerName(domainEvent.getServerName());
        eventPO.setClassName(domainEvent.getClassName());
        return eventPO;
    }
}
