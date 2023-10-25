package cn.xiaobage.warning.domain.warning.repository.persistence;

import cn.xiaobage.warning.domain.warning.entity.WarningRecord;
import cn.xiaobage.warning.domain.warning.repository.facade.WarningRecordRepository;
import cn.xiaobage.warning.domain.warning.repository.mapper.WarningRecordMapper;
import cn.xiaobage.warning.domain.warning.repository.po.WarningRecordPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预警记录 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Service
public class WarningRecordRepositoryImpl implements WarningRecordRepository {

    @Autowired
    WarningRecordMapper warningRecordMapper;

    @Override
    public int save(WarningRecordPO warningRecordPO) {
        return warningRecordMapper.insert(warningRecordPO);
    }

    @Override
    public WarningRecordPO query(Long warningRecordId) {
        return warningRecordMapper.selectById(warningRecordId);
    }
}
