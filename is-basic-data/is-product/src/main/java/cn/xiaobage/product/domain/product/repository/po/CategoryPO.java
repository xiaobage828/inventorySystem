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
 * 类目表
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("category")
@ApiModel(value = "CategoryPO对象", description = "类目表")
public class CategoryPO implements Serializable {


    private static final long serialVersionUID = -8866769853980040284L;
    @ApiModelProperty("类目ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("类目名称")
    @TableField("category_name")
    private String categoryName;

    @ApiModelProperty("父级分类ID")
    @TableField("parent_category_id")
    private Long parentCategoryId;


}
