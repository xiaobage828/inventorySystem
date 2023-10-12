package cn.xiaobage.warning.interfaces.assembler;

import cn.xiaobage.warning.domain.warning.entity.WarningRecord;
import cn.xiaobage.warning.interfaces.dto.WarningRecordDTO;

public class WariningRecordAssembler {

    public static WarningRecordDTO toDTO(WarningRecord warningRecord){
        WarningRecordDTO dto = new WarningRecordDTO();
        dto.setId(warningRecord.getId());
        dto.setCurrentInventory(warningRecord.getCurrentInventory());
        dto.setWarningTime(warningRecord.getWarningTime());
        dto.setMaximumInventory(warningRecord.getMaximumInventory());
        dto.setMinimumInventory(warningRecord.getMinimumInventory());
        dto.setInventoryId(warningRecord.getInventoryId());
        dto.setWarningPerson(warningRecord.getWarningPerson());
        dto.setWarningTime(warningRecord.getWarningTime());
        dto.setUnits(warningRecord.getUnits());
        return dto;
    }


    public static WarningRecord toDO(WarningRecordDTO warningRecordDTO){
        WarningRecord warningRecord = new WarningRecord();
        warningRecord.setId(warningRecordDTO.getId());
        warningRecord.setCurrentInventory(warningRecordDTO.getCurrentInventory());
        warningRecord.setWarningTime(warningRecordDTO.getWarningTime());
        warningRecord.setMaximumInventory(warningRecordDTO.getMaximumInventory());
        warningRecord.setMinimumInventory(warningRecordDTO.getMinimumInventory());
        warningRecord.setInventoryId(warningRecordDTO.getInventoryId());
        warningRecord.setWarningPerson(warningRecordDTO.getWarningPerson());
        warningRecord.setWarningTime(warningRecordDTO.getWarningTime());
        warningRecord.setUnits(warningRecordDTO.getUnits());
        return warningRecord;
    }
}
