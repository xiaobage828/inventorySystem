package cn.xiaobage.warehouse.domain.warehouse.repository.mapper;

import cn.xiaobage.warehouse.domain.warehouse.repository.po.WarehousePO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 仓库信息 Mapper 接口
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Mapper
public interface WarehouseMapper extends BaseMapper<WarehousePO> {

}
