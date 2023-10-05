package cn.xiaobage.product.domain.product.repository.facade;


import cn.xiaobage.product.domain.product.repository.po.CategoryPO;

/**
 * <p>
 * 类目表 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface CategoryRepository {

    CategoryPO queryCategory(Long categoryId);

}
