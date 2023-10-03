package cn.xiaobage.personnel.interfaces.facade;

import cn.xiaobage.personnel.infrastructure.common.api.Response;
import cn.xiaobage.personnel.interfaces.assembler.EmployeeAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class OrganizationApi {


    @GetMapping("/queryAllSubEmployeeByOrgId/{orgId}")
    public Response queryAllSubEmployeeByOrgId(@PathVariable("orgId") String orgId){
        return null;
//        return Response.ok(EmployeeAssembler.toDTO(employeeApplicationService.queryEmployeeByEmpId(orgId)));
    }

}
