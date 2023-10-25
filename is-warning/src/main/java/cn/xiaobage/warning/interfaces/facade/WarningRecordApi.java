package cn.xiaobage.warning.interfaces.facade;


import cn.xiaobage.config.api.Response;
import cn.xiaobage.warning.application.service.WarningRecordApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 预警记录 前端控制器
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@RestController
@RequestMapping("/warningRecord")
@Api(value = "WarningRecordApi", tags = { "预警记录访问接口" })
public class WarningRecordApi {

    @Autowired
    WarningRecordApplicationService warningRecordApplicationService;


    @ApiOperation(value= "query")
    @GetMapping("/query/{warningRecordId}")
    public Response query(@ApiParam(value = "预警记录id",name = "waringRecordId") Long waringRecordId){
        return Response.ok();
    }


}

