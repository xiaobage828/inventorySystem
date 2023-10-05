package cn.xiaobage.warehouse.domain.warehouse.entity;

import lombok.Data;

@Data
public class Warehouse {

    private Long id;

    private String name;

    private String address;

    private Integer personInCharge;

    private Long parentWarehouseId;
}
