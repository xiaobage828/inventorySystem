package cn.xiaobage.warehouse.domain.warehouse.service;

import cn.xiaobage.warehouse.domain.warehouse.entity.Warehouse;
import cn.xiaobage.warehouse.domain.warehouse.repository.po.WarehousePO;
import org.springframework.stereotype.Service;

@Service
public class WarehouseFactory {

    public Warehouse getWarehouse(WarehousePO warehousePO){
        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehousePO.getId());
        warehouse.setName(warehousePO.getName());
        warehouse.setAddress(warehousePO.getAddress());
        warehouse.setPersonInCharge(warehousePO.getPersonInCharge());
        warehouse.setParentWarehouseId(warehousePO.getParentWarehouseId());
        return warehouse;
    }
}
