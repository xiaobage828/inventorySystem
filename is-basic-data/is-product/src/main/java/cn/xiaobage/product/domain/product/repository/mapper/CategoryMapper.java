package cn.xiaobage.product.domain.product.repository.mapper;

import cn.xiaobage.product.domain.product.repository.po.CategoryPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 类目表 Mapper 接口
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryPO> {

}
