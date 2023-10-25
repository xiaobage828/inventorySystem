package cn.xiaobage.inventory.interfaces.facade;


import cn.xiaobage.config.api.Response;
import cn.xiaobage.inventory.application.service.WarehouseInRecordApplicationService;
import cn.xiaobage.inventory.interfaces.assembler.WarehouseInRecordAssembler;
import cn.xiaobage.inventory.interfaces.dto.WarehouseInRecordDTO;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "WarehouseInRecordApi", tags = { "入库单访问接口" })
@RequestMapping("/warehouseInRecord")
public class WarehouseInRecordApi {

    @Autowired
    WarehouseInRecordApplicationService WarehouseInRecordApplicationService;

    @ApiOperation(value= "create")
    @SentinelResource(value = "createWarehouseInRecord")
    @PostMapping("/createWarehouseInRecord")
    public Response createWarehouseInRecord(@ApiParam(value = "入库单DTO",name ="warehouseInRecordDTO") WarehouseInRecordDTO warehouseInRecordDTO){
        int updateRecord = WarehouseInRecordApplicationService.createWarehouseInRecord(WarehouseInRecordAssembler.toDO(warehouseInRecordDTO));
        return Response.ok(updateRecord);
    }
}

