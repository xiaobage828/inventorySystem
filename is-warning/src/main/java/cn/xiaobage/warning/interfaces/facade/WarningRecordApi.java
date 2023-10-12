package cn.xiaobage.warning.interfaces.facade;


import cn.xiaobage.config.api.Response;
import cn.xiaobage.warning.application.service.WarningRecordApplicationService;
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
public class WarningRecordApi {

    @Autowired
    WarningRecordApplicationService warningRecordApplicationService;

    @GetMapping("/query")
    public Response query(Long waringRecordId){
        return Response.ok();
    }


}

