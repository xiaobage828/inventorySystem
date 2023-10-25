package cn.xiaobage.warning.interfaces.facade;


import cn.xiaobage.config.api.Response;
import cn.xiaobage.warning.application.service.InventoryWarningConfigurationApplicationService;
import cn.xiaobage.warning.interfaces.assembler.InventoryWarningConfigurationAssembler;
import cn.xiaobage.warning.interfaces.dto.InventoryWarningConfigurationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 库存预警配置 前端控制器
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@RestController
@Api(value = "InventoryWarningConfigurationApi", tags = { "库存预警配置访问接口" })
@RequestMapping("/inventoryWarningConfiguration")
public class InventoryWarningConfigurationApi {

    @Autowired
    private InventoryWarningConfigurationApplicationService inventoryWarningConfigurationApplicationService;

    @ApiOperation(value= "query")
    @GetMapping("/query/{inventoryId}")
    public Response query(@ApiParam(value = "库存id",name = "inventoryId") @PathVariable  Long inventoryId){
        return Response.ok(InventoryWarningConfigurationAssembler.toDTO(inventoryWarningConfigurationApplicationService.query(inventoryId)));
    }

    @ApiOperation(value= "save")
    @PostMapping("/save")
    public Response create(@ApiParam(value = "库存预警配置DTO",name = "dto") InventoryWarningConfigurationDTO dto){
        return Response.ok(inventoryWarningConfigurationApplicationService.save(InventoryWarningConfigurationAssembler.toDO(dto)));
    }

    @ApiOperation(value= "update")
    @PostMapping("/update")
    public Response update(@ApiParam(value = "库存预警配置DTO",name = "dto") InventoryWarningConfigurationDTO dto){
        return Response.ok(inventoryWarningConfigurationApplicationService.update(InventoryWarningConfigurationAssembler.toDO(dto)));
    }
}

