package cn.xiaobage.domainEvent.domain.domainEvent.service;

import cn.xiaobage.domainEvent.domain.domainEvent.entity.DomainEvent;
import cn.xiaobage.domainEvent.domain.domainEvent.repository.facade.DomainEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainEventDomainService {

    @Autowired
    DomainEventRepository domainEventRepositoryImpl;

    @Autowired
    DomainEventFactory domainEventFactory;

    public int save(DomainEvent domainEvent){
        return domainEventRepositoryImpl.saveDomainEvent(domainEventFactory.createDomainEventPO(domainEvent));
    }
}
