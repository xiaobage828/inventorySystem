package cn.xiaobage.personnel.interfaces.facade;

import cn.xiaobage.common.api.Response;
import cn.xiaobage.personnel.application.service.EmployeeApplicationService;
import cn.xiaobage.personnel.interfaces.assembler.EmployeeAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeApi {


    @Autowired
    EmployeeApplicationService employeeApplicationService;


    @GetMapping("/queryEmployeeByEmpId/{empId}")
    public Response queryEmployeeByEmpId(@PathVariable("empId") String empId){
        return Response.ok(EmployeeAssembler.toDTO(employeeApplicationService.queryEmployeeByEmpId(empId)));
    }

    @GetMapping("/queryCurEmployeeByOrgId/{orgId}")
    public Response queryCurEmployeeByOrgId(@PathVariable("orgId") String orgId){
        return Response.ok(employeeApplicationService.queryCurEmployeeByOrgId(orgId).stream().map(employee -> EmployeeAssembler.toDTO(employee)));
    }



}
