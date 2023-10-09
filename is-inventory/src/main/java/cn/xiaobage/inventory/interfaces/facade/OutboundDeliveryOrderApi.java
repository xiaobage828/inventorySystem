package cn.xiaobage.inventory.interfaces.facade;


import cn.xiaobage.common.api.Response;
import cn.xiaobage.inventory.application.service.OutboundDeliveryOrderApplicationService;
import cn.xiaobage.inventory.interfaces.assembler.OutboundDeliveryOrderAssembler;
import cn.xiaobage.inventory.interfaces.dto.OutboundDeliveryOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 出库单 前端控制器
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@RestController
@RequestMapping("/outboundDeliveryOrder")
public class OutboundDeliveryOrderApi {

    @Autowired
    OutboundDeliveryOrderApplicationService outboundDeliveryOrderApplicationService;

    @PostMapping("/create")
    public Response createOutboundDeliveryOrder(OutboundDeliveryOrderDTO outboundDeliveryOrderDTO){
        return Response.ok(outboundDeliveryOrderApplicationService.createOutboundDeliveryOrder(OutboundDeliveryOrderAssembler.toDo(outboundDeliveryOrderDTO)));
    }

}
