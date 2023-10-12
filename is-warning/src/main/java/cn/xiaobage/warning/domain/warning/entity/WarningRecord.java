package cn.xiaobage.warning.domain.warning.entity;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WarningRecord {

    private Long id;

    private Long inventoryId;

    private Integer currentInventory;

    private Integer minimumInventory;

    private Integer maximumInventory;

    private String units;

    private Integer warningPerson;

    private LocalDate warningTime;

    private LocalDate createTime;

    public WarningRecord  fromInventoryWaringConfiguration(InventoryWarningConfiguration inventoryWarningConfiguration, Integer totalQuantity){
        setCurrentInventory(totalQuantity);
        setInventoryId(inventoryWarningConfiguration.getInventoryId());
        setWarningPerson(inventoryWarningConfiguration.getWarningPerson());
        setUnits(inventoryWarningConfiguration.getUnits());
        setCreateTime(inventoryWarningConfiguration.getCreateTime());
        setMinimumInventory(inventoryWarningConfiguration.getMinimumInventory());
        setMaximumInventory(inventoryWarningConfiguration.getMaximumInventory());
        return this;
    }

    public WarningRecord create(){
        setWarningTime(LocalDate.now());
        setId(IdUtil.getSnowflakeNextId());
        return this;
    }

}
