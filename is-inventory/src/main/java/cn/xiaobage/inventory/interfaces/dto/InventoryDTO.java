package cn.xiaobage.inventory.interfaces.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class InventoryDTO {

    private Long id;

    private Long warehouseId;

    private Long productId;

    private Integer totalQuantity;

    private Integer lockQuantity;

    private Integer damagedQuantity;

    private String units;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate updateTime;
}
