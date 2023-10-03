package cn.xiaobage.personnel.domain.employee.service;

import cn.xiaobage.personnel.domain.employee.entity.Employee;
import cn.xiaobage.personnel.domain.employee.repository.po.EmployeePO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFactory {

    public Employee getEmployee(EmployeePO po){
        if(null == po) return null;
        Employee employee = new Employee();
        employee.setEmpId(po.getEmpId());
        employee.setEmpName(po.getEmpName());
        employee.setSalary(po.getSalary());
        return employee;
    }
}
