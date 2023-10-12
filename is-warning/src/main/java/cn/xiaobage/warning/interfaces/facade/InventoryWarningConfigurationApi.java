package cn.xiaobage.warning.interfaces.facade;


import cn.xiaobage.config.api.Response;
import cn.xiaobage.warning.application.service.InventoryWarningConfigurationApplicationService;
import cn.xiaobage.warning.interfaces.assembler.InventoryWarningConfigurationAssembler;
import cn.xiaobage.warning.interfaces.dto.InventoryWarningConfigurationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库存预警配置 前端控制器
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@RestController
@RequestMapping("/inventoryWarningConfiguration")
public class InventoryWarningConfigurationApi {

    @Autowired
    private InventoryWarningConfigurationApplicationService inventoryWarningConfigurationApplicationService;

    @GetMapping("/query/{inventoryId}")
    public Response query(Long inventoryId){
        return Response.ok(InventoryWarningConfigurationAssembler.toDTO(inventoryWarningConfigurationApplicationService.query(inventoryId)));
    }


    @PostMapping("/save")
    public Response create(InventoryWarningConfigurationDTO dto){
        return Response.ok(InventoryWarningConfigurationAssembler.toDO(dto));
    }

    @PostMapping("/update")
    public Response update(InventoryWarningConfigurationDTO dto){
        return Response.ok(InventoryWarningConfigurationAssembler.toDO(dto));
    }
}

