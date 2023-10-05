package cn.xiaobage.product.domain.product.service;

import cn.xiaobage.product.domain.product.entity.Category;
import cn.xiaobage.product.domain.product.repository.po.CategoryPO;
import org.springframework.stereotype.Service;

@Service
public class CategoryFactory {

    public Category  createCategory(CategoryPO categoryPO){
        Category category = new Category();
        category.setId(categoryPO.getId());
        category.setCategoryName(categoryPO.getCategoryName());
        category.setParentCategoryId(categoryPO.getParentCategoryId());
        return category;
    }
}
