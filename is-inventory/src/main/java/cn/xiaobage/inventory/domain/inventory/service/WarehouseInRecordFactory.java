package cn.xiaobage.inventory.domain.inventory.service;

import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import cn.xiaobage.inventory.domain.inventory.repository.po.WarehouseInRecordPO;
import org.springframework.stereotype.Service;

@Service
public class WarehouseInRecordFactory {

    public WarehouseInRecordPO getWarehouseInRecordPO(WarehouseInRecord warehouseInRecord){
        WarehouseInRecordPO warehouseInRecordPO = new WarehouseInRecordPO();
        warehouseInRecordPO.setId(warehouseInRecord.getId());
        warehouseInRecordPO.setCreateTime(warehouseInRecord.getCreateTime());
        warehouseInRecordPO.setUnits(warehouseInRecord.getUnits());
        warehouseInRecordPO.setMaker(warehouseInRecord.getMaker());
        warehouseInRecordPO.setQuantity(warehouseInRecord.getQuantity());
        warehouseInRecordPO.setRecordCode(warehouseInRecord.getRecordCode());
        warehouseInRecordPO.setRemark(warehouseInRecord.getRemark());
        warehouseInRecordPO.setInventoryId(warehouseInRecord.getInventoryId());
        warehouseInRecordPO.setTag(warehouseInRecord.getTag());
        warehouseInRecordPO.setTimeOfMaking(warehouseInRecord.getTimeOfMaking());
        warehouseInRecordPO.setTradingTime(warehouseInRecord.getTradingTime());
        warehouseInRecordPO.setTrader(warehouseInRecord.getTrader());
        return warehouseInRecordPO;
    }
}
