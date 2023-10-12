package cn.xiaobage.inventory.domain.inventory.repository.facade;


import cn.xiaobage.inventory.domain.inventory.repository.po.InventoryPO;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 库存 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface InventoryRepository  {

    List<InventoryPO> queryInventory(Long inventoryId, Long warehouseId, Long productId);

    int insertInventory(InventoryPO inventoryPO);

    int inventoryIncrement(Long inventoryId, Integer quantity, LocalDate updateTime);

    int inventoryDecrement(Long inventoryId, Integer quantity, LocalDate updateTime);
}
