package cn.xiaobage.inventory.domain.inventory.repository.facade;

import cn.xiaobage.inventory.domain.inventory.repository.po.OutboundDeliveryOrderPO;

/**
 * <p>
 * 出库单 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface OutboundDeliveryOrderRepository{

    int insert(OutboundDeliveryOrderPO outboundDeliveryOrderPO);
}
