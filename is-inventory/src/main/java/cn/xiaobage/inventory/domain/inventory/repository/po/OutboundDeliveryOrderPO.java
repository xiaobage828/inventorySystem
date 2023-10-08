package cn.xiaobage.inventory.domain.inventory.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 出库单
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("outbound_delivery_order")
@ApiModel(value = "OutboundDeliveryOrderPO对象", description = "出库单")
public class OutboundDeliveryOrderPO implements Serializable {


    private static final long serialVersionUID = -3156452465803742080L;


    @ApiModelProperty("存库单ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("单据流水号")
    @TableField("record_code")
    private String recordCode;

    @ApiModelProperty("库存ID，来自inventory表的id字段")
    @TableField("inventory_id")
    private Long inventoryId;

    @ApiModelProperty("存库标签")
    @TableField("tag")
    private String tag;

    @ApiModelProperty("存库数量")
    @TableField("quantity")
    private Integer quantity;

    @ApiModelProperty("计量单位")
    @TableField("units")
    private String units;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("交易方")
    @TableField("trader")
    private String trader;

    @ApiModelProperty("交易时间")
    @TableField("trading_time")
    private LocalDate tradingTime;

    @ApiModelProperty("单据制作时间")
    @TableField("time_of_making")
    private LocalDate timeOfMaking;

    @ApiModelProperty("制单人，来自employee表的emp_id")
    @TableField("maker")
    private Integer maker;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDate createTime;


}
