package cn.xiaobage.inventory.application.service;

import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.domain.inventory.event.OutboundDeliveryOrderCreateEvent;
import cn.xiaobage.inventory.domain.inventory.service.OutboundDeliveryOrderDomainService;
import cn.xiaobage.inventory.infrastructure.client.DomainEventFeignClient;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisOpsInventory;
import cn.xiaobage.inventory.interfaces.assembler.DomainEventAssembler;
import cn.xiaobage.inventory.interfaces.dto.DomainEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

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
        int updateRecord =  outboundDeliveryOrderDomainService.createOutboundDeliveryOrder(outboundDeliveryOrder);

        if(updateRecord > 0){
            Long inventoryId = redisOpsInventory.invokeInventoryDeductionLua(outboundDeliveryOrder);
            OutboundDeliveryOrderCreateEvent inventoryUpdateEvent = OutboundDeliveryOrderCreateEvent.create(outboundDeliveryOrder);
            DomainEventDTO domainEventDTO = DomainEventAssembler.toDTO(inventoryUpdateEvent);
            domainEventFeignClient.save(domainEventDTO);
            applicationContext.publishEvent(inventoryUpdateEvent);
        }

        return updateRecord;
    }
}
