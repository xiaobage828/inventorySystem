package cn.xiaobage.warning.domain.warning.service;

import cn.xiaobage.warning.domain.warning.entity.InventoryWarningConfiguration;
import cn.xiaobage.warning.domain.warning.repository.po.InventoryWarningConfigurationPO;
import org.springframework.stereotype.Service;

@Service
public class InventoryWarningConfigurationFactory {

    public InventoryWarningConfigurationPO createInventoryWarningConfigurationPO(InventoryWarningConfiguration inventoryWarningConfiguration) {
        InventoryWarningConfigurationPO po = new InventoryWarningConfigurationPO();
        po.setInventoryId(inventoryWarningConfiguration.getInventoryId());
        po.setUnits(inventoryWarningConfiguration.getUnits());
        po.setMaximumInventory(inventoryWarningConfiguration.getMaximumInventory());
        po.setMinimumInventory(inventoryWarningConfiguration.getMinimumInventory());
        po.setWarningPerson(inventoryWarningConfiguration.getWarningPerson());
        po.setCreateTime(inventoryWarningConfiguration.getCreateTime());
        po.setUpdateTime(inventoryWarningConfiguration.getUpdateTime());
        return po;
    }

    public InventoryWarningConfiguration getDO(InventoryWarningConfigurationPO inventoryWarningConfigurationPO){
        InventoryWarningConfiguration inventoryWarningConfiguration = new InventoryWarningConfiguration();
        inventoryWarningConfiguration.setInventoryId(inventoryWarningConfigurationPO.getInventoryId());
        inventoryWarningConfiguration.setUnits(inventoryWarningConfigurationPO.getUnits());
        inventoryWarningConfiguration.setMaximumInventory(inventoryWarningConfigurationPO.getMaximumInventory());
        inventoryWarningConfiguration.setMinimumInventory(inventoryWarningConfigurationPO.getMinimumInventory());
        inventoryWarningConfiguration.setWarningPerson(inventoryWarningConfigurationPO.getWarningPerson());
        inventoryWarningConfiguration.setCreateTime(inventoryWarningConfigurationPO.getCreateTime());
        inventoryWarningConfiguration.setUpdateTime(inventoryWarningConfigurationPO.getUpdateTime());
        return inventoryWarningConfiguration;
    }
}
