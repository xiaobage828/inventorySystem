package cn.xiaobage.warning.domain.warning.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class InventoryWarningConfiguration {

    private Long inventoryId;

    private Integer minimumInventory;

    private Integer maximumInventory;

    private String units;

    private Integer warningPerson;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    public InventoryWarningConfiguration create(){
        this.createTime = new Date();
        this.updateTime = this.createTime;
        return this;
    }

    public InventoryWarningConfiguration update(){
        this.updateTime = new Date();
        return this;
    }

    public boolean lowInventory(int currentQuantity){
        return null != minimumInventory && currentQuantity < minimumInventory;
    }

    public boolean highInventory(int currentQuantity){
        return null != maximumInventory && currentQuantity > maximumInventory;
    }

}
