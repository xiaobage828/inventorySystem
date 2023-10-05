package cn.xiaobage.product.domain.product.repository.facade;


import cn.xiaobage.product.domain.product.repository.po.ProductPO;

/**
 * <p>
 * 产品信息表 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface ProductRepository{

    ProductPO queryProduct(Long productId);

}
