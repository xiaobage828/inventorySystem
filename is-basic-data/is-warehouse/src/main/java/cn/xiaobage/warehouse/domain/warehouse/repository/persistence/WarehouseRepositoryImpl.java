package cn.xiaobage.warehouse.domain.warehouse.repository.persistence;


import cn.xiaobage.warehouse.domain.warehouse.repository.facade.WarehouseRepository;
import cn.xiaobage.warehouse.domain.warehouse.repository.mapper.WarehouseMapper;
import cn.xiaobage.warehouse.domain.warehouse.repository.po.WarehousePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库信息 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Repository
public class WarehouseRepositoryImpl implements WarehouseRepository {

    @Autowired
    WarehouseMapper warehouseMapper;

    @Override
    public WarehousePO queryWarehouse(Long warehouseId) {
        return warehouseMapper.selectById(warehouseId);
    }
}
