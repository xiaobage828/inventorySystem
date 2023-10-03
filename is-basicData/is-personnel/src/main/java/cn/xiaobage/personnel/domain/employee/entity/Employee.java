package cn.xiaobage.personnel.domain.employee.entity;

import cn.xiaobage.personnel.domain.organization.entity.Organization;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee {

    String empId;

    String empName;

    Organization organization;

    BigDecimal salary;
}
