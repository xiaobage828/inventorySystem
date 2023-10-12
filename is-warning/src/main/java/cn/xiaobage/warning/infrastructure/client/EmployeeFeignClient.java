package cn.xiaobage.warning.infrastructure.client;

import cn.xiaobage.config.api.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(name = "is-personnel",path = "/employee")
public interface EmployeeFeignClient {

    @GetMapping(value = "/queryEmployeeByEmpId/{empId}")
    @ResponseBody
    Response queryEmployeeByEmpId(@PathVariable String empId);
}
