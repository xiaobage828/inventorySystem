package cn.xiaobage.warehouse.interfaces.facade;


import cn.xiaobage.common.api.Response;
import cn.xiaobage.warehouse.application.service.WarehouseApplicationService;
import cn.xiaobage.warehouse.interfaces.assembler.WarehouseAssembler;
import cn.xiaobage.warehouse.interfaces.dto.WarehouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 仓库信息 前端控制器
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseApi {

    @Autowired
    WarehouseApplicationService warehouseApplicationService;

    @GetMapping("/queryWarehouse")
    public Response queryWarehouse(@RequestParam("warehouseId") Long warehouseId){
        WarehouseDTO dto = WarehouseAssembler.toDTO(warehouseApplicationService.queryWarehouse(warehouseId));
        return Response.ok(dto);
    }
}

