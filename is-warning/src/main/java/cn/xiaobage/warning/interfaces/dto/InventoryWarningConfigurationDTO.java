package cn.xiaobage.warning.interfaces.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class InventoryWarningConfigurationDTO {


    private Long inventoryId;

    private Integer minimumInventory;

    private Integer maximumInventory;

    private String units;

    private Integer warningPerson;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateTime;

}
