package cn.xiaobage.inventory.application.service;

import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.domain.inventory.event.InventoryUpdateEvent;
import cn.xiaobage.inventory.domain.inventory.event.OutboundDeliveryOrderCreateEvent;
import cn.xiaobage.inventory.domain.inventory.service.OutboundDeliveryOrderDomainService;
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
public class OutboundDeliveryOrderApplicationService {

    @Autowired
    OutboundDeliveryOrderDomainService outboundDeliveryOrderDomainService;

    @Autowired
    RedisOpsInventory redisOpsInventory;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DomainEventFeignClient domainEventFeignClient;

    public int createOutboundDeliveryOrder(OutboundDeliveryOrder outboundDeliveryOrder){

        log.info("出库单开始处理:{}",outboundDeliveryOrder);

        int updateRecord =  outboundDeliveryOrderDomainService.createOutboundDeliveryOrder(outboundDeliveryOrder);

        if(updateRecord > 0){
            Inventory inventory = redisOpsInventory.invokeInventoryDeductionLua(outboundDeliveryOrder);
            InventoryUpdateEvent inventoryUpdateEvent = InventoryUpdateEvent.create(inventory);
            DomainEventDTO inventoryUpdateEventDTO = DomainEventAssembler.toDTO(inventoryUpdateEvent);
            domainEventFeignClient.save(inventoryUpdateEventDTO);
            applicationContext.publishEvent(inventoryUpdateEvent);

            OutboundDeliveryOrderCreateEvent outboundDeliveryOrderEvent = OutboundDeliveryOrderCreateEvent.create(outboundDeliveryOrder);
            DomainEventDTO outboundDeliveryOrderEventDTO = DomainEventAssembler.toDTO(outboundDeliveryOrderEvent);
            domainEventFeignClient.save(outboundDeliveryOrderEventDTO);
            applicationContext.publishEvent(outboundDeliveryOrderEvent);
        }

        return updateRecord;
    }
}
