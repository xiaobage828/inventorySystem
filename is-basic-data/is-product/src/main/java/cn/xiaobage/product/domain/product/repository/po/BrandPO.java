package cn.xiaobage.product.domain.product.repository.po;

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
 * 品牌表
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("brand")
@ApiModel(value = "BrandPO对象", description = "品牌表")
public class BrandPO implements Serializable {

    private static final long serialVersionUID = -1480680363420230513L;
    @ApiModelProperty("品牌ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("品牌中文名")
    @TableField("brand_cn_name")
    private String brandCnName;

    @ApiModelProperty("品牌英文名")
    @TableField("brand_en_name")
    private String brandEnName;

    @ApiModelProperty("品牌Logo")
    @TableField("logo_url")
    private String logoUrl;

    @ApiModelProperty("品牌故事")
    @TableField("brand_story")
    private String brandStory;


}
