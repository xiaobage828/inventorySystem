package cn.xiaobage.warning.interfaces.assembler;


import cn.xiaobage.warning.domain.warning.entity.InventoryWarningConfiguration;
import cn.xiaobage.warning.interfaces.dto.InventoryWarningConfigurationDTO;

public class InventoryWarningConfigurationAssembler {

    public static InventoryWarningConfigurationDTO toDTO(InventoryWarningConfiguration inventoryWarningConfiguration){
        InventoryWarningConfigurationDTO dto = new InventoryWarningConfigurationDTO();
        dto.setInventoryId(inventoryWarningConfiguration.getInventoryId());
        dto.setUnits(inventoryWarningConfiguration.getUnits());
        dto.setMaximumInventory(inventoryWarningConfiguration.getMaximumInventory());
        dto.setMinimumInventory(inventoryWarningConfiguration.getMinimumInventory());
        dto.setWarningPerson(inventoryWarningConfiguration.getWarningPerson());
        dto.setCreateTime(inventoryWarningConfiguration.getCreateTime());
        dto.setUpdateTime(inventoryWarningConfiguration.getUpdateTime());
        return dto;
    }

    public static InventoryWarningConfiguration toDO(InventoryWarningConfigurationDTO dto){
        InventoryWarningConfiguration configuration = new InventoryWarningConfiguration();
        configuration.setInventoryId(dto.getInventoryId());
        configuration.setUnits(dto.getUnits());
        configuration.setMaximumInventory(dto.getMaximumInventory());
        configuration.setMinimumInventory(dto.getMinimumInventory());
        configuration.setWarningPerson(dto.getWarningPerson());
        configuration.setCreateTime(dto.getCreateTime());
        configuration.setUpdateTime(dto.getUpdateTime());
        return configuration;
    }

}
