package cn.xiaobage.inventory.domain.inventory.repository.persistence;

import cn.xiaobage.inventory.domain.inventory.repository.facade.WarehouseInRecordRepository;
import cn.xiaobage.inventory.domain.inventory.repository.mapper.WarehouseInRecordMapper;
import cn.xiaobage.inventory.domain.inventory.repository.po.WarehouseInRecordPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 入库单 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Service
public class WarehouseInRecordRepositoryImpl implements WarehouseInRecordRepository {

    @Autowired
    WarehouseInRecordMapper warehouseInRecordMapper;

    @Override
    public int insert(WarehouseInRecordPO warehouseInRecordPO){
        return warehouseInRecordMapper.insert(warehouseInRecordPO);
    }

}
