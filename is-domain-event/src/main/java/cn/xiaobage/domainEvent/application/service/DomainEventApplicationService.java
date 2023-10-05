package cn.xiaobage.domainEvent.application.service;

import cn.xiaobage.domainEvent.domain.domainEvent.entity.DomainEvent;
import cn.xiaobage.domainEvent.domain.domainEvent.service.DomainEventDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainEventApplicationService {

    @Autowired
    DomainEventDomainService domainEventDomainService;

    public int save(DomainEvent domainEvent){
        return domainEventDomainService.save(domainEvent);
    }

}
