package cn.xiaobage.warehouse.domain.warehouse.service;

import cn.xiaobage.warehouse.domain.warehouse.entity.Warehouse;
import cn.xiaobage.warehouse.domain.warehouse.repository.facade.WarehouseRepository;
import cn.xiaobage.warehouse.domain.warehouse.repository.po.WarehousePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseDomainService {

    @Autowired
    WarehouseRepository warehouseRepositoryImpl;

    @Autowired
    WarehouseFactory warehouseFactory;


    public Warehouse queryWarehouse(Long warehouseId){
        WarehousePO warehousePO = warehouseRepositoryImpl.queryWarehouse(warehouseId);
        return warehouseFactory.getWarehouse(warehousePO);
    }
}
