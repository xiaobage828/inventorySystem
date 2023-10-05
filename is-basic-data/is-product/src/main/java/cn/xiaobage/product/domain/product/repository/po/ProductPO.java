package cn.xiaobage.product.domain.product.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品信息表
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("product")
@ApiModel(value = "ProductPO对象", description = "产品信息表")
public class ProductPO implements Serializable {

    private static final long serialVersionUID = 3361462404518116268L;

    @ApiModelProperty("产品ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("销售状态 1上架 2下架")
    @TableField("sale_status")
    private Boolean saleStatus;

    @ApiModelProperty("图片路径")
    @TableField("img_url")
    private String imgUrl;

    @ApiModelProperty("商品编码")
    @TableField("pro_no")
    private String proNo;

    @ApiModelProperty("品牌id")
    @TableField("brand_id")
    private Long brandId;

    @ApiModelProperty("分类id")
    @TableField("category_id")
    private Long categoryId;

    @ApiModelProperty("商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("成本价")
    @TableField("cost_price")
    private BigDecimal costPrice;

    @ApiModelProperty("批发价")
    @TableField("wholesale_price")
    private BigDecimal wholesalePrice;

    @ApiModelProperty("零售价")
    @TableField("retail_price")
    private BigDecimal retailPrice;

    @ApiModelProperty("商品描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDate createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDate updateTime;


}
