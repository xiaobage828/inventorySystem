package cn.xiaobage.personnel.application.service;

import cn.xiaobage.personnel.domain.employee.entity.Employee;
import cn.xiaobage.personnel.domain.employee.service.EmployeeDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeApplicationService {

    @Autowired
    EmployeeDomainService employeeDomainService;

    public Employee queryEmployeeByEmpId(String empId){
        return employeeDomainService.queryEmployeeByEmpId(empId);
    }

    public List<Employee> queryCurEmployeeByOrgId(String empId){
        return employeeDomainService.queryCurEmployeeByOrgId(empId);
    }
}
