package cn.xiaobage.inventory.interfaces.assembler;

import cn.hutool.core.util.IdUtil;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.interfaces.dto.InventoryDTO;

public class InventoryAssembler {

    public static InventoryDTO toDTO(Inventory inventory){
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setId(inventory.getId());
        inventoryDTO.setUnits(inventory.getUnits());
        inventoryDTO.setProductId(inventory.getProductId());
        inventoryDTO.setLockQuantity(inventory.getLockQuantity());
        inventoryDTO.setCreateTime(inventory.getCreateTime());
        inventoryDTO.setUpdateTime(inventory.getUpdateTime());
        inventoryDTO.setDamagedQuantity(inventory.getDamagedQuantity());
        inventoryDTO.setTotalQuantity(inventory.getTotalQuantity());
        inventoryDTO.setWarehouseId(inventory.getWarehouseId());
        return inventoryDTO;
    }

    public static Inventory toDO(InventoryDTO dto){
        Inventory inventory = new Inventory();
        inventory.setId(dto.getId());
        inventory.setUnits(dto.getUnits());
        inventory.setProductId(dto.getProductId());
        inventory.setLockQuantity(dto.getLockQuantity());
        inventory.setCreateTime(dto.getCreateTime());
        inventory.setUpdateTime(dto.getUpdateTime());
        inventory.setDamagedQuantity(dto.getDamagedQuantity());
        inventory.setTotalQuantity(dto.getTotalQuantity());
        inventory.setWarehouseId(dto.getWarehouseId());
        return inventory;
    }

}
