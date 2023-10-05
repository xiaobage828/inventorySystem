package cn.xiaobage.domainEvent.domain.domainEvent.repository.facade;


import cn.xiaobage.domainEvent.domain.domainEvent.repository.po.DomainEventPO;

/**
 * <p>
 * 领域事件 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface DomainEventRepository {

    int saveDomainEvent(DomainEventPO domainEventPO);

}
