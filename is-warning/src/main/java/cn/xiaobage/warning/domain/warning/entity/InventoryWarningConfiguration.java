package cn.xiaobage.warning.domain.warning.entity;

import lombok.Data;
import java.util.Date;

@Data
public class InventoryWarningConfiguration {

    private Long inventoryId;

    private Integer minimumInventory;

    private Integer maximumInventory;

    private String units;

    private Integer warningPerson;

    private Date createTime;

    private Date updateTime;


    public boolean lowInventory(int currentQuantity){
        return null != maximumInventory && currentQuantity < maximumInventory;
    }

    public boolean highInventory(int currentQuantity){
        return null != maximumInventory && currentQuantity > maximumInventory;
    }

}
