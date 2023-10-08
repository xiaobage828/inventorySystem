package cn.xiaobage.inventory.domain.inventory.repository.mapper;

import cn.xiaobage.inventory.domain.inventory.repository.po.InventoryPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 库存 Mapper 接口
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Mapper
public interface InventoryMapper extends BaseMapper<InventoryPO> {

}
