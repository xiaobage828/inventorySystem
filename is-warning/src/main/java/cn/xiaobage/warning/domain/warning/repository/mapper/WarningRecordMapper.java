package cn.xiaobage.warning.domain.warning.repository.mapper;

import cn.xiaobage.warning.domain.warning.repository.po.WarningRecordPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 预警记录 Mapper 接口
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Mapper
public interface WarningRecordMapper extends BaseMapper<WarningRecordPO> {

}
