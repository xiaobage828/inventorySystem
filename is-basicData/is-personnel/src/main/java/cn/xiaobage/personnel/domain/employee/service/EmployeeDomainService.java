package cn.xiaobage.personnel.domain.employee.service;

import cn.xiaobage.personnel.domain.employee.entity.Employee;
import cn.xiaobage.personnel.domain.employee.repository.facade.EmployeeRepository;
import cn.xiaobage.personnel.domain.employee.repository.po.EmployeePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeDomainService {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    @Autowired
    EmployeeFactory employeeFactory;


    public Employee queryEmployeeByEmpId(String empId){
        EmployeePO employeePO = employeeRepositoryImpl.queryEmployeeByEmpId(empId);
        return employeeFactory.getEmployee(employeePO);
    }

    public List<Employee> queryCurEmployeeByOrgId(String orgId){
        List<EmployeePO> employeePOList = employeeRepositoryImpl.queryCurEmployeeByOrgId(orgId);
        return employeePOList.stream().map(employeePO -> employeeFactory.getEmployee(employeePO)).collect(Collectors.toList());
    }


}
