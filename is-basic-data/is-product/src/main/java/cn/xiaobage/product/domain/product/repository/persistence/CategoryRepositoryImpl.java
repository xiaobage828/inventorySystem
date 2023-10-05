package cn.xiaobage.product.domain.product.repository.persistence;

import cn.xiaobage.product.domain.product.repository.facade.CategoryRepository;
import cn.xiaobage.product.domain.product.repository.mapper.CategoryMapper;
import cn.xiaobage.product.domain.product.repository.po.CategoryPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 类目表 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryPO queryCategory(Long categoryId) {
        return categoryMapper.selectById(categoryId);
    }
}
