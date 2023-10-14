package cn.xiaobage.warning.application.service;

import cn.xiaobage.warning.domain.warning.entity.InventoryWarningConfiguration;
import cn.xiaobage.warning.domain.warning.entity.WarningRecord;
import cn.xiaobage.warning.domain.warning.event.WarningRecordCreateEvent;
import cn.xiaobage.warning.domain.warning.service.InventoryWarningConfigurationDomainService;
import cn.xiaobage.warning.domain.warning.service.WarningRecordDomainService;
import cn.xiaobage.warning.infrastructure.client.DomainEventFeignClient;
import cn.xiaobage.warning.interfaces.assembler.DomainEventAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WarningRecordApplicationService {

    @Autowired
    InventoryWarningConfigurationDomainService inventoryWarningConfigurationDomainService;

    @Autowired
    WarningRecordDomainService warningRecordDomainService;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DomainEventFeignClient domainEventFeignClient;

    public void triggerInventoryWarningIfNecessary(Long inventoryId, Integer currentQuantity){
        InventoryWarningConfiguration inventoryWarningConfiguration = inventoryWarningConfigurationDomainService.query(inventoryId);
        if(null == inventoryWarningConfiguration)
            return;
        if(!inventoryWarningConfiguration.lowInventory(currentQuantity) && !inventoryWarningConfiguration.highInventory(currentQuantity)) //既不是低库存，也不是高库存
            return;
        WarningRecord warningRecord = new WarningRecord();
        warningRecord.fromInventoryWaringConfiguration(inventoryWarningConfiguration,currentQuantity);
        warningRecordDomainService.createWarningRecord(warningRecord);
        WarningRecordCreateEvent warningRecordCreateEvent = WarningRecordCreateEvent.create(warningRecord);
        domainEventFeignClient.save(DomainEventAssembler.toDTO(warningRecordCreateEvent));
        applicationContext.publishEvent(warningRecordCreateEvent);
    }
}
