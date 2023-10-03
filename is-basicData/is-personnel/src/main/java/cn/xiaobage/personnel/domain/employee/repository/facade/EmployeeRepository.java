package cn.xiaobage.personnel.domain.employee.repository.facade;

import cn.xiaobage.personnel.domain.employee.repository.po.EmployeePO;

import java.util.List;

public interface EmployeeRepository {

    EmployeePO queryEmployeeByEmpId(String empId);

    List<EmployeePO> queryCurEmployeeByOrgId(String orgId);
}
