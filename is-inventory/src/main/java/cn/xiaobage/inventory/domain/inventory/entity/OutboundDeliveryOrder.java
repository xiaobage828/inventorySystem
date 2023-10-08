package cn.xiaobage.inventory.domain.inventory.entity;

import lombok.Data;

import java.time.LocalDate;


@Data
public class OutboundDeliveryOrder {

    private Long id;

    private String recordCode;

    private Long inventoryId;

    private String tag;

    private Integer quantity;

    private String units;

    private String remark;

    private String trader;

    private LocalDate tradingTime;

    private LocalDate timeOfMaking;

    private Integer maker;

    private LocalDate createTime;
}
