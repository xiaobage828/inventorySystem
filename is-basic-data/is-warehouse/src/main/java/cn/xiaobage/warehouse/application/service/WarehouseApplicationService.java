package cn.xiaobage.warehouse.application.service;

import cn.xiaobage.warehouse.domain.warehouse.entity.Warehouse;
import cn.xiaobage.warehouse.domain.warehouse.service.WarehouseDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseApplicationService {

    @Autowired
    WarehouseDomainService warehouseDomainService;

    public Warehouse queryWarehouse(Long warehouseId){
        return warehouseDomainService.queryWarehouse(warehouseId);
    }
}
