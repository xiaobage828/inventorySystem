package cn.xiaobage.inventory.application.service;


import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.event.InventoryCreateEvent;
import cn.xiaobage.inventory.domain.inventory.service.InventoryDomainService;
import cn.xiaobage.inventory.infrastructure.client.DomainEventFeignClient;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisOpsInventory;
import cn.xiaobage.inventory.interfaces.assembler.DomainEventAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.Date;
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

    public int inventoryIncrement(Long inventoryId, Integer quantity, Date updateTime){
        return inventoryDomainService.inventoryIncrement(inventoryId,quantity,updateTime);
    }

    public int inventoryDecrement(Long inventoryId, Integer quantity, Date updateTime ){
        return inventoryDomainService.inventoryDecrement(inventoryId,quantity,updateTime);
    }

}
