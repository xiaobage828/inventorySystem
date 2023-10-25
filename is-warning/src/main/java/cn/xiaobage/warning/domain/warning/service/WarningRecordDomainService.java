package cn.xiaobage.warning.domain.warning.service;


import cn.xiaobage.warning.domain.warning.entity.WarningRecord;
import cn.xiaobage.warning.domain.warning.repository.facade.WarningRecordRepository;
import cn.xiaobage.warning.domain.warning.repository.po.WarningRecordPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarningRecordDomainService {

    @Autowired
    WarningRecordRepository warningRecordRepository;

    @Autowired
    WarningRecordFactory warningRecordFactory;


    public int createWarningRecord(WarningRecord warningRecord){
        warningRecord.create();
        WarningRecordPO po = warningRecordFactory.createWarningRecordPO(warningRecord);
        return warningRecordRepository.save(po);
    }

    public WarningRecord query(Long warningRecordId){
        WarningRecordPO warningRecordPO = warningRecordRepository.query(warningRecordId);
        return warningRecordFactory.getWarningRecord(warningRecordPO);
    }

}
