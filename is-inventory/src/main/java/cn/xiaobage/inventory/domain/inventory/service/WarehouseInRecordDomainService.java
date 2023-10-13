package cn.xiaobage.inventory.domain.inventory.service;

import cn.xiaobage.inventory.domain.inventory.entity.WarehouseInRecord;
import cn.xiaobage.inventory.domain.inventory.repository.facade.WarehouseInRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseInRecordDomainService {

    @Autowired
    WarehouseInRecordRepository warehouseInRecordRepositoryImpl;

    @Autowired
    WarehouseInRecordFactory warehouseInRecordFactory;

    public int createWarehouseInRecord(WarehouseInRecord warehouseInRecord){
        warehouseInRecord.create();
        return warehouseInRecordRepositoryImpl.insert(warehouseInRecordFactory.createWarehouseInRecordPO(warehouseInRecord));
    }
}
