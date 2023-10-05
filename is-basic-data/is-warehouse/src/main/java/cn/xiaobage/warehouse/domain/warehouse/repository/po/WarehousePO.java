package cn.xiaobage.warehouse.domain.warehouse.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 仓库信息
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("warehouse")
@ApiModel(value = "WarehousePO对象", description = "仓库信息")
public class WarehousePO implements Serializable {


    private static final long serialVersionUID = -2023320265759426959L;
    @ApiModelProperty("仓库ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("仓库名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("仓库地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("负责人，来自employee表的emp_id")
    @TableField("person_in_charge")
    private Integer personInCharge;

    @ApiModelProperty("父级仓库ID")
    @TableField("parent_warehouse_id")
    private Long parentWarehouseId;


}
