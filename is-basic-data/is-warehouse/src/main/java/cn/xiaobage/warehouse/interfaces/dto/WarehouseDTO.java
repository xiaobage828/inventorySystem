package cn.xiaobage.warehouse.interfaces.dto;

import lombok.Data;

@Data
public class WarehouseDTO {

    private Long id;

    private String name;

    private String address;

    private Integer personInCharge;

    private Long parentWarehouseId;
}
