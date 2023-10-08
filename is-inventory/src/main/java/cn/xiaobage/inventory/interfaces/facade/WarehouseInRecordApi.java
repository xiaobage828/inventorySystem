package cn.xiaobage.inventory.interfaces.facade;


import cn.xiaobage.common.api.Response;
import cn.xiaobage.inventory.application.service.WarehouseInRecordApplicationService;
import cn.xiaobage.inventory.interfaces.assembler.WarehouseInRecordAssembler;
import cn.xiaobage.inventory.interfaces.dto.WarehouseInRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 入库单 前端控制器
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@RestController
@RequestMapping("/warehouseInRecord")
public class WarehouseInRecordApi {

    @Autowired
    WarehouseInRecordApplicationService WarehouseInRecordApplicationService;

    @PostMapping("/createWarehouseInRecord")
    public Response createWarehouseInRecord(WarehouseInRecordDTO warehouseInRecordDTO){
        int updateRecord = WarehouseInRecordApplicationService.createWarehouseInRecord(WarehouseInRecordAssembler.toDO(warehouseInRecordDTO));
        return Response.ok(updateRecord);
    }
}

