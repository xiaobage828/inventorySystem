package cn.xiaobage.warehouse.domain.warehouse.repository.facade;


import cn.xiaobage.warehouse.domain.warehouse.repository.po.WarehousePO;

/**
 * <p>
 * 仓库信息 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface WarehouseRepository{

    WarehousePO queryWarehouse(Long warehouseId);
}
