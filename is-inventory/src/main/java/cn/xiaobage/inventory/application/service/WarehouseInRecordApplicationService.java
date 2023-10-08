package cn.xiaobage.inventory.application.service;

import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import cn.xiaobage.inventory.domain.inventory.event.WarehouseInRecordCreateEvent;
import cn.xiaobage.inventory.domain.inventory.service.WarehouseInRecordDomainService;
import cn.xiaobage.inventory.infrastructure.client.DomainEventFeignClient;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisOpsInventory;
import cn.xiaobage.inventory.interfaces.assembler.DomainEventAssembler;
import cn.xiaobage.inventory.interfaces.dto.DomainEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WarehouseInRecordApplicationService {

    @Autowired
    WarehouseInRecordDomainService warehouseInRecordDomainService;

    @Autowired
    RedisOpsInventory redisOpsInventory;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DomainEventFeignClient domainEventFeignClient;

    public int createWarehouseInRecord(WarehouseInRecord warehouseInRecord){
        int updateRecord = warehouseInRecordDomainService.createWarehouseInRecord(warehouseInRecord);
        if(updateRecord > 0){
            Long inventoryId = redisOpsInventory.invokeIncrementLua(warehouseInRecord);
            WarehouseInRecordCreateEvent inventoryUpdateEvent = WarehouseInRecordCreateEvent.create(warehouseInRecord);
            DomainEventDTO domainEventDTO = DomainEventAssembler.toDTO(inventoryUpdateEvent);
            domainEventFeignClient.save(domainEventDTO);
            applicationContext.publishEvent(inventoryUpdateEvent);
        }
        return updateRecord;
    }

}
