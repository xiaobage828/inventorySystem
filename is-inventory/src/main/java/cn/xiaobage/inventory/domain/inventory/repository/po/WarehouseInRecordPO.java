package cn.xiaobage.inventory.domain.inventory.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 入库单
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("warehouse_in_record")
@ApiModel(value = "WarehouseInRecordPO对象", description = "入库单")
public class WarehouseInRecordPO implements Serializable {

    private static final long serialVersionUID = -669828054713985703L;
    @ApiModelProperty("入库单ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("单据流水号")
    @TableField("record_code")
    private String recordCode;

    @ApiModelProperty("库存ID，来自inventory表的id字段")
    @TableField("inventory_id")
    private Long inventoryId;

    @ApiModelProperty("入库标签")
    @TableField("tag")
    private String tag;

    @ApiModelProperty("入库数量")
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
    private Date tradingTime;

    @ApiModelProperty("单据制作时间")
    @TableField("time_of_making")
    private Date timeOfMaking;

    @ApiModelProperty("制单人，来自employee表的emp_id")
    @TableField("maker")
    private Integer maker;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;


}
