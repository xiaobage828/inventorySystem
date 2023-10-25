package cn.xiaobage.inventory.interfaces.facade;


import cn.xiaobage.config.api.Response;
import cn.xiaobage.inventory.application.service.InventoryApplicationService;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.interfaces.assembler.InventoryAssembler;
import cn.xiaobage.inventory.interfaces.dto.InventoryDTO;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 库存 前端控制器
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@RestController
@Api(value = "InventoryApi", tags = { "库存访问接口" })
@RequestMapping("/inventory")
public class InventoryApi {

    @Autowired
    InventoryApplicationService inventoryApplicationService;


    @SentinelResource("queryInventory")
    @GetMapping("/queryInventory")
    public Response queryInventory(Long inventoryId,Long warehouseId,Long productId){
        List<Inventory> inventoryList = inventoryApplicationService.queryInventory(inventoryId,warehouseId,productId);
        List<InventoryDTO> inventoryDTOList = inventoryList.stream().map(inventory -> InventoryAssembler.toDTO(inventory)).collect(Collectors.toList());
        return Response.ok(inventoryDTOList);
    }

    @ApiOperation(value = "query")
    @SentinelResource("queryInventoryFromCache")
    @GetMapping("/query/{inventoryId}")
    public Response queryInventory(@ApiParam(value = "入库单id",name = "inventoryId") @PathVariable Long inventoryId){
        Inventory inventory = inventoryApplicationService.queryInventoryByIdFromCacheAndDB(inventoryId);
        InventoryDTO inventoryDTO = null == inventory ? null : InventoryAssembler.toDTO(inventory);
        return Response.ok(inventoryDTO);
    }

    @ApiOperation(value = "create")
    @PostMapping("/createInventory")
    public Response createInventory(@ApiParam(value = "库存DTO",name ="inventoryDTO") InventoryDTO inventoryDTO){
        int updateRecord = inventoryApplicationService.createInventory(InventoryAssembler.toDO(inventoryDTO));
        return Response.ok(updateRecord);
    }



}

