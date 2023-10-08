package cn.xiaobage.inventory.domain.inventory.repository.mapper;

import cn.xiaobage.inventory.domain.inventory.repository.po.OutboundDeliveryOrderPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 出库单 Mapper 接口
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Mapper
public interface OutboundDeliveryOrderMapper extends BaseMapper<OutboundDeliveryOrderPO> {

}
