package cn.xiaobage.domainEvent.domain.domainEvent.repository.mapper;

import cn.xiaobage.domainEvent.domain.domainEvent.repository.po.DomainEventPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 领域事件 Mapper 接口
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Mapper
public interface DomainEventMapper extends BaseMapper<DomainEventPO> {

}
