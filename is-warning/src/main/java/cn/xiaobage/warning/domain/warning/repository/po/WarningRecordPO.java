package cn.xiaobage.warning.domain.warning.repository.po;

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
 * 预警记录
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("warning_record")
@ApiModel(value = "WarningRecordPO对象", description = "预警记录")
public class WarningRecordPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("预警记录ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("库存ID")
    @TableField("inventory_id")
    private Long inventoryId;

    @ApiModelProperty("当前库存")
    @TableField("current_inventory")
    private Integer currentInventory;

    @ApiModelProperty("最小库存")
    @TableField("minimum_inventory")
    private Integer minimumInventory;

    @ApiModelProperty("最大库存")
    @TableField("maximum_inventory")
    private Integer maximumInventory;

    @ApiModelProperty("计量单位")
    @TableField("units")
    private String units;

    @ApiModelProperty("预警人，来自employee表的emp_id")
    @TableField("warning_person")
    private Integer warningPerson;

    @ApiModelProperty("预警时间")
    @TableField("warning_time")
    private LocalDate warningTime;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDate createTime;


}
