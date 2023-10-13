package cn.xiaobage.warning.domain.warning.service;

import cn.xiaobage.warning.domain.warning.entity.InventoryWarningConfiguration;
import cn.xiaobage.warning.domain.warning.repository.facade.InventoryWarningConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryWarningConfigurationDomainService {

    @Autowired
    InventoryWarningConfigurationRepository inventoryWarningConfigurationRepositoryImpl;

    @Autowired
    InventoryWarningConfigurationFactory inventoryWarningConfigurationFactory;

    public InventoryWarningConfiguration query(Long inventoryId){
        return inventoryWarningConfigurationFactory.getDO(inventoryWarningConfigurationRepositoryImpl.query(inventoryId));
    }

    public int save(InventoryWarningConfiguration inventoryWarningConfiguration){
        inventoryWarningConfiguration.create();
        return inventoryWarningConfigurationRepositoryImpl.save(inventoryWarningConfigurationFactory.createInventoryWarningConfigurationPO(inventoryWarningConfiguration));
    }

    public int update(InventoryWarningConfiguration inventoryWarningConfiguration){
        inventoryWarningConfiguration.update();
        return inventoryWarningConfigurationRepositoryImpl.update(inventoryWarningConfigurationFactory.createInventoryWarningConfigurationPO(inventoryWarningConfiguration));
    }
}
