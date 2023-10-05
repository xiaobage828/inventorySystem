package cn.xiaobage.product.domain.product.repository.persistence;

import cn.xiaobage.product.domain.product.repository.facade.ProductRepository;
import cn.xiaobage.product.domain.product.repository.mapper.ProductMapper;
import cn.xiaobage.product.domain.product.repository.po.ProductPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 产品信息表 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductPO queryProduct(Long productId) {
        return productMapper.selectById(productId);
    }
}
