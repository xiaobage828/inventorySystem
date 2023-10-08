package cn.xiaobage.inventory.domain.inventory.repository.facade;


import cn.xiaobage.inventory.domain.inventory.repository.po.WarehouseInRecordPO;

/**
 * <p>
 * 入库单 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface WarehouseInRecordRepository  {
    int insert(WarehouseInRecordPO warehouseInRecordPO);
}
