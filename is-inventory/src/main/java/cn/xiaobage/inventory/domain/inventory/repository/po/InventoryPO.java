package cn.xiaobage.inventory.domain.inventory.repository.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 库存
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("inventory")
@ApiModel(value = "InventoryPO对象", description = "库存")
public class InventoryPO implements Serializable {


    private static final long serialVersionUID = -8156738454452829152L;

    @ApiModelProperty("库存ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("仓库ID")
    @TableField("warehouse_id")
    private Long warehouseId;

    @ApiModelProperty("产品ID")
    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("剩余库存")
    @TableField("total_quantity")
    private Integer totalQuantity;

    @ApiModelProperty("锁定库存")
    @TableField("lock_quantity")
    private Integer lockQuantity;

    @ApiModelProperty("损坏库存")
    @TableField("damaged_quantity")
    private Integer damagedQuantity;

    @ApiModelProperty("计量单位")
    @TableField("units")
    private String units;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDate createTime;

    @ApiModelProperty("修改时间")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDate updateTime;


}
