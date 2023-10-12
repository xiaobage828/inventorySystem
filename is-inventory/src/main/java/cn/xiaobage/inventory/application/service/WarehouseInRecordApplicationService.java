package cn.xiaobage.inventory.application.service;

import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import cn.xiaobage.inventory.domain.inventory.event.InventoryUpdateEvent;
import cn.xiaobage.inventory.domain.inventory.event.WarehouseInRecordCreateEvent;
import cn.xiaobage.inventory.domain.inventory.service.WarehouseInRecordDomainService;
import cn.xiaobage.inventory.infrastructure.client.DomainEventFeignClient;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisOpsInventory;
import cn.xiaobage.inventory.interfaces.assembler.DomainEventAssembler;
import cn.xiaobage.inventory.interfaces.dto.DomainEventDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Slf4j
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

        log.info("入库单处理开始：{}",warehouseInRecord);

        int updateRecord = warehouseInRecordDomainService.createWarehouseInRecord(warehouseInRecord);
        if(updateRecord > 0){
            Inventory inventory = redisOpsInventory.invokeIncrementLua(warehouseInRecord);
            InventoryUpdateEvent inventoryUpdateEvent = InventoryUpdateEvent.create(inventory);
            DomainEventDTO inventoryUpdateEventDTO = DomainEventAssembler.toDTO(inventoryUpdateEvent);
            domainEventFeignClient.save(inventoryUpdateEventDTO);
            applicationContext.publishEvent(inventoryUpdateEvent);

            WarehouseInRecordCreateEvent warehouseInRecordCreateEvent = WarehouseInRecordCreateEvent.create(warehouseInRecord);
            DomainEventDTO warehouseInRecordCreateEventDTO = DomainEventAssembler.toDTO(warehouseInRecordCreateEvent);
            domainEventFeignClient.save(warehouseInRecordCreateEventDTO);
            applicationContext.publishEvent(warehouseInRecordCreateEvent);
        }
        return updateRecord;
    }

}
