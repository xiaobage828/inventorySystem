package cn.xiaobage.warning.application.service;

import cn.xiaobage.warning.domain.warning.entity.InventoryWarningConfiguration;
import cn.xiaobage.warning.domain.warning.service.InventoryWarningConfigurationDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryWarningConfigurationApplicationService {

    @Autowired
    InventoryWarningConfigurationDomainService inventoryWarningConfigurationDomainService;

    public InventoryWarningConfiguration query(Long inventoryId){
        return inventoryWarningConfigurationDomainService.query(inventoryId);
    }

    public int save(InventoryWarningConfiguration inventoryWarningConfiguration){
        return inventoryWarningConfigurationDomainService.save(inventoryWarningConfiguration);
    }

    public int update(InventoryWarningConfiguration inventoryWarningConfiguration){
        return inventoryWarningConfigurationDomainService.update(inventoryWarningConfiguration);
    }
}
