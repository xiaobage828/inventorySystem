package cn.xiaobage.warehouse.interfaces.assembler;

import cn.xiaobage.warehouse.domain.warehouse.entity.Warehouse;
import cn.xiaobage.warehouse.interfaces.dto.WarehouseDTO;

public class WarehouseAssembler {

    public static WarehouseDTO toDTO(Warehouse warehouse){
        WarehouseDTO dto = new WarehouseDTO();
        dto.setId(warehouse.getId());
        dto.setName(warehouse.getName());
        dto.setParentWarehouseId(warehouse.getParentWarehouseId());
        dto.setAddress(warehouse.getAddress());
        dto.setPersonInCharge(warehouse.getPersonInCharge());
        return dto;
    }
}
