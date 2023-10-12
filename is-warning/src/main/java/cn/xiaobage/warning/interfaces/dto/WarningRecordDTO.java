package cn.xiaobage.warning.interfaces.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WarningRecordDTO {

    private Long id;

    private Long inventoryId;

    private Integer currentInventory;

    private Integer minimumInventory;

    private Integer maximumInventory;

    private String units;

    private Integer warningPerson;

    private LocalDate warningTime;

    private LocalDate createTime;

}
