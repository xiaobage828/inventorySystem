package cn.xiaobage.inventory.domain.inventory.repository.persistence;

import cn.xiaobage.inventory.domain.inventory.repository.facade.InventoryRepository;
import cn.xiaobage.inventory.domain.inventory.repository.mapper.InventoryMapper;
import cn.xiaobage.inventory.domain.inventory.repository.po.InventoryPO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 库存 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Service
public class InventoryRepositoryImpl implements InventoryRepository {

    @Autowired
    InventoryMapper inventoryMapper;

    @Override
    public List<InventoryPO> queryInventory(Long inventoryId, Long warehouseId, Long productId) {
        QueryWrapper<InventoryPO> queryWrapper = new QueryWrapper<>();
        if(null != inventoryId)
            queryWrapper.eq("id",inventoryId);
        if(null != warehouseId)
            queryWrapper.eq("warehouse_id",warehouseId);
        if(null != productId)
            queryWrapper.eq("product_id",productId);
        return inventoryMapper.selectList(queryWrapper);
    }

    @Override
    public int insertInventory(InventoryPO inventoryPO) {
        return inventoryMapper.insert(inventoryPO);
    }

    @Override
    public int inventoryIncrement(Long inventoryId, Integer quantity, LocalDate updateTime) {
        return inventoryMapper.inventoryIncrement(inventoryId,quantity,updateTime);
    }

    @Override
    public int inventoryDecrement(Long inventoryId, Integer quantity, LocalDate updateTime) {
        return inventoryMapper.inventoryDecrement(inventoryId,quantity,updateTime);
    }
}
