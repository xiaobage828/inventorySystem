package cn.xiaobage.inventory.interfaces.assembler;

import cn.hutool.core.util.IdUtil;
import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import cn.xiaobage.inventory.domain.inventory.repository.po.WarehouseInRecordPO;
import cn.xiaobage.inventory.interfaces.dto.WarehouseInRecordDTO;

import java.time.LocalDate;

public class WarehouseInRecordAssembler {

    public static WarehouseInRecord toDO(WarehouseInRecordDTO dto){
        WarehouseInRecord warehouseInRecord = new WarehouseInRecord();
        warehouseInRecord.setId(null == dto.getId()? IdUtil.getSnowflakeNextId(): dto.getId());
        warehouseInRecord.setCreateTime(null == dto.getCreateTime()? LocalDate.now():dto.getCreateTime());
        warehouseInRecord.setUnits(dto.getUnits());
        warehouseInRecord.setMaker(dto.getMaker());
        warehouseInRecord.setQuantity(dto.getQuantity());
        warehouseInRecord.setRecordCode(dto.getRecordCode());
        warehouseInRecord.setRemark(dto.getRemark());
        warehouseInRecord.setInventoryId(dto.getInventoryId());
        warehouseInRecord.setTag(dto.getTag());
        warehouseInRecord.setTimeOfMaking(dto.getTimeOfMaking());
        warehouseInRecord.setTradingTime(dto.getTradingTime());
        warehouseInRecord.setTrader(dto.getTrader());
        return warehouseInRecord;
    }

    public static WarehouseInRecordDTO toDTO(WarehouseInRecord warehouseInRecord){
        WarehouseInRecordDTO warehouseInRecordDTO = new WarehouseInRecordDTO();
        warehouseInRecordDTO.setId(warehouseInRecord.getId());
        warehouseInRecordDTO.setCreateTime(warehouseInRecord.getCreateTime());
        warehouseInRecordDTO.setUnits(warehouseInRecord.getUnits());
        warehouseInRecordDTO.setMaker(warehouseInRecord.getMaker());
        warehouseInRecordDTO.setQuantity(warehouseInRecord.getQuantity());
        warehouseInRecordDTO.setRecordCode(warehouseInRecord.getRecordCode());
        warehouseInRecordDTO.setRemark(warehouseInRecord.getRemark());
        warehouseInRecordDTO.setInventoryId(warehouseInRecord.getInventoryId());
        warehouseInRecordDTO.setTag(warehouseInRecord.getTag());
        warehouseInRecordDTO.setTimeOfMaking(warehouseInRecord.getTimeOfMaking());
        warehouseInRecordDTO.setTradingTime(warehouseInRecord.getTradingTime());
        warehouseInRecordDTO.setTrader(warehouseInRecord.getTrader());
        return warehouseInRecordDTO;
    }
}
