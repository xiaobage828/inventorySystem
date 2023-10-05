package cn.xiaobage.product.domain.product.repository.facade;

import cn.xiaobage.product.domain.product.repository.mapper.BrandMapper;
import cn.xiaobage.product.domain.product.repository.po.BrandPO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface BrandRepository {

    BrandPO queryBrand(Long categoryId);
}
