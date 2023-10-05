package cn.xiaobage.product.domain.product.repository.persistence;

import cn.xiaobage.product.domain.product.repository.facade.BrandRepository;
import cn.xiaobage.product.domain.product.repository.mapper.BrandMapper;
import cn.xiaobage.product.domain.product.repository.po.BrandPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Repository
public class BrandRepositoryImpl implements BrandRepository {



    @Autowired
    BrandMapper brandMapper;

    @Override
    public BrandPO queryBrand(Long categoryId) {
        return brandMapper.selectById(categoryId);
    }
}
