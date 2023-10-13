package cn.xiaobage.inventory.domain.inventory.entity;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import java.util.Date;


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

    private Date tradingTime;

    private Date timeOfMaking;

    private Integer maker;

    private Date createTime;

    public OutboundDeliveryOrder create(){
        id = IdUtil.getSnowflakeNextId();
        this.createTime = new Date();
        return this;
    }
}
