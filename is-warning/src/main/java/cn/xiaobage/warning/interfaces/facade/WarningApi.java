package cn.xiaobage.warning.interfaces.facade;

import cn.xiaobage.common.api.Response;
import cn.xiaobage.warning.application.service.WarningApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warning")
public class WarningApi {

    @Autowired
    WarningApplicationService warningApplicationService;

    @GetMapping("/queryEmployeeByEmpId/{empId}")
    public Response queryEmployeeByEmpId(@PathVariable String empId){
        return warningApplicationService.queryEmployeeByEmpId(empId);
    }
}
