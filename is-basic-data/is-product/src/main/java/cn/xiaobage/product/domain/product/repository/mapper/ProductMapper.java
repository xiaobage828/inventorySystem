package cn.xiaobage.product.domain.product.repository.mapper;

import cn.xiaobage.product.domain.product.repository.po.ProductPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 产品信息表 Mapper 接口
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Mapper
public interface ProductMapper extends BaseMapper<ProductPO> {

}
