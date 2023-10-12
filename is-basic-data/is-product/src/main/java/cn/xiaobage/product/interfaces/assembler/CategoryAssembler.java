package cn.xiaobage.product.interfaces.assembler;

import cn.xiaobage.product.domain.product.entity.Category;
import cn.xiaobage.product.interfaces.dto.CategoryDTO;

public class CategoryAssembler {


    public static CategoryDTO toDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setParentCategoryId(category.getParentCategoryId());
        return categoryDTO;
    }
}
