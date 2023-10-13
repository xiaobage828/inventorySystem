package cn.xiaobage.inventory.domain.inventory.service;

import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.repository.po.InventoryPO;
import org.springframework.stereotype.Service;

@Service
public class InventoryFactory {

    public Inventory getInventory(InventoryPO po){
        Inventory inventory = new Inventory();
        inventory.setId(po.getId());
        inventory.setUnits(po.getUnits());
        inventory.setProductId(po.getProductId());
        inventory.setLockQuantity(po.getLockQuantity());
        inventory.setCreateTime(po.getCreateTime());
        inventory.setUpdateTime(po.getUpdateTime());
        inventory.setDamagedQuantity(po.getDamagedQuantity());
        inventory.setTotalQuantity(po.getTotalQuantity());
        inventory.setWarehouseId(po.getWarehouseId());
        return inventory;
    }

    public InventoryPO createInventoryPO(Inventory inventory){
        InventoryPO po = new InventoryPO();
        po.setId(inventory.getId());
        po.setUnits(inventory.getUnits());
        po.setProductId(inventory.getProductId());
        po.setLockQuantity(inventory.getLockQuantity());
        po.setCreateTime(inventory.getCreateTime());
        po.setUpdateTime(inventory.getUpdateTime());
        po.setDamagedQuantity(inventory.getDamagedQuantity());
        po.setTotalQuantity(inventory.getTotalQuantity());
        po.setWarehouseId(inventory.getWarehouseId());
        return po;
    }
}
