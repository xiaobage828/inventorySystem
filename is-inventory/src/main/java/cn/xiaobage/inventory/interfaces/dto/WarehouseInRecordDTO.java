package cn.xiaobage.inventory.interfaces.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class WarehouseInRecordDTO {

    private Long id;

    private String recordCode;

    private Long inventoryId;

    private String tag;

    private Integer quantity;

    private String units;

    private String remark;

    private String trader;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate tradingTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate timeOfMaking;

    private Integer maker;
    
    private LocalDate createTime;
}
