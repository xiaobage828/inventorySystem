package cn.xiaobage.warning.domain.warning.service;

import cn.xiaobage.warning.domain.warning.entity.WarningRecord;
import cn.xiaobage.warning.domain.warning.repository.po.WarningRecordPO;
import org.springframework.stereotype.Service;

@Service
public class WarningRecordFactory {

    public WarningRecordPO createWarningRecordPO(WarningRecord warningRecord){
        WarningRecordPO po = new WarningRecordPO();
        po.setId(warningRecord.getId());
        po.setWarningPerson(warningRecord.getWarningPerson());
        po.setCreateTime(warningRecord.getCreateTime());
        po.setWarningTime(warningRecord.getWarningTime());
        po.setUnits(warningRecord.getUnits());
        po.setCurrentInventory(warningRecord.getCurrentInventory());
        po.setMaximumInventory(warningRecord.getMaximumInventory());
        po.setMinimumInventory(warningRecord.getMinimumInventory());
        po.setInventoryId(warningRecord.getInventoryId());
        return po;
    }

    public WarningRecord getWarningRecord(WarningRecordPO po){
        WarningRecord warningRecord = new WarningRecord();
        warningRecord.setId(po.getId());
        warningRecord.setWarningPerson(po.getWarningPerson());
        warningRecord.setCreateTime(po.getCreateTime());
        warningRecord.setWarningTime(po.getWarningTime());
        warningRecord.setUnits(po.getUnits());
        warningRecord.setCurrentInventory(po.getCurrentInventory());
        warningRecord.setMaximumInventory(po.getMaximumInventory());
        warningRecord.setMinimumInventory(po.getMinimumInventory());
        warningRecord.setInventoryId(po.getInventoryId());
        return warningRecord;
    }
}
