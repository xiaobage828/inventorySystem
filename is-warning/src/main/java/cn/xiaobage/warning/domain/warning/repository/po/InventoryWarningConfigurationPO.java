package cn.xiaobage.warning.domain.warning.repository.po;

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
 * 库存预警配置
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("inventory_warning_configuration")
@ApiModel(value = "InventoryWarningConfigurationPO对象", description = "库存预警配置")
public class InventoryWarningConfigurationPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("库存ID")
    @TableId(value = "inventory_id", type = IdType.ASSIGN_ID)
    private Long inventoryId;

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

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private Date updateTime;


}
