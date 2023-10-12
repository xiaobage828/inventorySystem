package cn.xiaobage.warning.domain.warning.repository.facade;


import cn.xiaobage.warning.domain.warning.repository.po.WarningRecordPO;

/**
 * <p>
 * 预警记录 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface WarningRecordRepository {

    int save(WarningRecordPO warningRecordPO);
}
