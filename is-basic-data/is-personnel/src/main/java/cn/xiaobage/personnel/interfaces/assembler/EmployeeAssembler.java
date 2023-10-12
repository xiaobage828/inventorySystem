package cn.xiaobage.personnel.interfaces.assembler;

import cn.xiaobage.personnel.domain.employee.entity.Employee;
import cn.xiaobage.personnel.interfaces.dto.EmployeeDTO;

public class EmployeeAssembler {


    public static EmployeeDTO toDTO(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmpId(employee.getEmpId());
        dto.setEmpName(employee.getEmpName());
        dto.setSalary(employee.getSalary());
        return dto;
    }
}
