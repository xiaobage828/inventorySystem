package cn.xiaobage.warning.domain.warning.entity;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class WarningRecord {

    private Long id;

    private Long inventoryId;

    private Integer currentInventory;

    private Integer minimumInventory;

    private Integer maximumInventory;

    private String units;

    private Integer warningPerson;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date warningTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

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
        setWarningTime(new Date());
        this.createTime = warningTime;
        setId(IdUtil.getSnowflakeNextId());
        return this;
    }

}
