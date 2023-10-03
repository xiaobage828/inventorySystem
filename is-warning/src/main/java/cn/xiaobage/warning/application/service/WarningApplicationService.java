package cn.xiaobage.warning.application.service;

import cn.xiaobage.common.api.Response;
import cn.xiaobage.warning.infrastructure.client.EmployeeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarningApplicationService {

    @Autowired
    EmployeeFeignClient employeeFeignClient;

    public Response queryEmployeeByEmpId(String empId){
        return employeeFeignClient.queryEmployeeByEmpId(empId);
    }
}
