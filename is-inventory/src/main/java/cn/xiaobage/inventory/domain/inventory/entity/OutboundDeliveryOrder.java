package cn.xiaobage.inventory.domain.inventory.entity;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tradingTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeOfMaking;

    private Integer maker;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public OutboundDeliveryOrder create(){
        id = IdUtil.getSnowflakeNextId();
        this.createTime = new Date();
        return this;
    }
}
