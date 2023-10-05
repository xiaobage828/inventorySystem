package cn.xiaobage.product.interfaces.dto;

import lombok.Data;

@Data
public class CategoryDTO {

    private Long id;

    private String categoryName;

    private Long parentCategoryId;
}
