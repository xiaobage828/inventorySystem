package cn.xiaobage.inventory.domain.inventory.service;

import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.repository.facade.InventoryRepository;
import cn.xiaobage.inventory.domain.inventory.repository.po.InventoryPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryDomainService {

    @Autowired
    InventoryRepository inventoryRepositoryImpl;

    @Autowired
    InventoryFactory inventoryFactory;

    public List<Inventory> queryInventory(Long inventoryId, Long warehouseId, Long productId){
        List<InventoryPO> inventoryPOList = inventoryRepositoryImpl.queryInventory(inventoryId,warehouseId,productId);
        return inventoryPOList.stream().map(inventoryPO -> inventoryFactory.getInventory(inventoryPO)).collect(Collectors.toList());
    }

    public int createInventory(Inventory inventory){
        return inventoryRepositoryImpl.insertInventory(inventoryFactory.getInventoryPO(inventory));
    }

}