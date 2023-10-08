package cn.xiaobage.inventory.application.service;


import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import cn.xiaobage.inventory.domain.inventory.event.InventoryCreateEvent;
import cn.xiaobage.inventory.domain.inventory.service.InventoryDomainService;
import cn.xiaobage.inventory.infrastructure.client.DomainEventFeignClient;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisOpsInventory;
import cn.xiaobage.inventory.interfaces.assembler.DomainEventAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InventoryApplicationService {

    @Autowired
    InventoryDomainService inventoryDomainService;


    @Autowired
    ApplicationContext applicationContext;


    @Autowired
    DomainEventFeignClient domainEventFeignClient;

    @Autowired
    RedisOpsInventory redisOpsInventory;


    public List<Inventory> queryInventory(Long inventoryId, Long warehouseId, Long productId){
        return inventoryDomainService.queryInventory(inventoryId,warehouseId,productId);
    }

    public int createInventory(Inventory inventory){
        int updateRecord = inventoryDomainService.createInventory(inventory);
        if(updateRecord > 0){
            redisOpsInventory.saveInventory(inventory);
        }
        InventoryCreateEvent inventoryCreateEvent = InventoryCreateEvent.create(inventory);
        domainEventFeignClient.save(DomainEventAssembler.toDTO(inventoryCreateEvent));
        applicationContext.publishEvent(inventoryCreateEvent);
        return updateRecord;
    }


}
