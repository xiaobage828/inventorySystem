package cn.xiaobage.inventory.domain.inventory.repository.persistence;

import cn.xiaobage.inventory.domain.inventory.repository.facade.OutboundDeliveryOrderRepository;
import cn.xiaobage.inventory.domain.inventory.repository.mapper.OutboundDeliveryOrderMapper;
import cn.xiaobage.inventory.domain.inventory.repository.po.OutboundDeliveryOrderPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 出库单 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Service
public class OutboundDeliveryOrderRepositoryImpl implements OutboundDeliveryOrderRepository {

    @Autowired
    OutboundDeliveryOrderMapper outboundDeliveryOrderMapper;

    @Override
    public int insert(OutboundDeliveryOrderPO outboundDeliveryOrderPO) {
        return outboundDeliveryOrderMapper.insert(outboundDeliveryOrderPO);
    }
}
