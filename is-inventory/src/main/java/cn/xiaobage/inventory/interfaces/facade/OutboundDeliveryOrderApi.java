package cn.xiaobage.inventory.interfaces.facade;


import cn.xiaobage.config.api.Response;
import cn.xiaobage.inventory.application.service.OutboundDeliveryOrderApplicationService;
import cn.xiaobage.inventory.interfaces.assembler.OutboundDeliveryOrderAssembler;
import cn.xiaobage.inventory.interfaces.dto.OutboundDeliveryOrderDTO;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "OutboundDeliveryOrderApi", tags = { "出库单访问接口" })
@RequestMapping("/outboundDeliveryOrder")
public class OutboundDeliveryOrderApi {

    @Autowired
    OutboundDeliveryOrderApplicationService outboundDeliveryOrderApplicationService;

    @ApiOperation(value= "create")
    @SentinelResource(value = "createOutboundDeliveryOrder")
    @PostMapping("/create")
    public Response createOutboundDeliveryOrder(@ApiParam(value = "出库单DTO",name ="outboundDeliveryOrderDTO") OutboundDeliveryOrderDTO outboundDeliveryOrderDTO){
        return Response.ok(outboundDeliveryOrderApplicationService.createOutboundDeliveryOrder(OutboundDeliveryOrderAssembler.toDo(outboundDeliveryOrderDTO)));
    }

}

