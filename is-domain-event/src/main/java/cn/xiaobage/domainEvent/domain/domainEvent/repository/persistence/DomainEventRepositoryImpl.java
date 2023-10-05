package cn.xiaobage.domainEvent.domain.domainEvent.repository.persistence;

import cn.xiaobage.domainEvent.domain.domainEvent.repository.facade.DomainEventRepository;
import cn.xiaobage.domainEvent.domain.domainEvent.repository.mapper.DomainEventMapper;
import cn.xiaobage.domainEvent.domain.domainEvent.repository.po.DomainEventPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 领域事件 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Service
public class DomainEventRepositoryImpl implements DomainEventRepository {

    @Autowired
    DomainEventMapper domainEventMapper;

    public int saveDomainEvent(DomainEventPO domainEventPO){
        return domainEventMapper.insert(domainEventPO);
    }

}
