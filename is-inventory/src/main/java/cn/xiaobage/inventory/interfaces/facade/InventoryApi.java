package cn.xiaobage.inventory.interfaces.facade;


import cn.xiaobage.config.api.Response;
import cn.xiaobage.inventory.application.service.InventoryApplicationService;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.interfaces.assembler.InventoryAssembler;
import cn.xiaobage.inventory.interfaces.dto.InventoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/inventory")
public class InventoryApi {

    @Autowired
    InventoryApplicationService inventoryApplicationService;



    @GetMapping("/queryInventory")
    public Response queryInventory(Long inventoryId,Long warehouseId,Long productId){
        List<Inventory> inventoryList = inventoryApplicationService.queryInventory(inventoryId,warehouseId,productId);
        List<InventoryDTO> inventoryDTOList = inventoryList.stream().map(inventory -> InventoryAssembler.toDTO(inventory)).collect(Collectors.toList());
        return Response.ok(inventoryDTOList);
    }

    @PostMapping("/createInventory")
    public Response createInventory(InventoryDTO inventoryDTO){
        int updateRecord = inventoryApplicationService.createInventory(InventoryAssembler.toDO(inventoryDTO));
        return Response.ok(updateRecord);
    }



}

