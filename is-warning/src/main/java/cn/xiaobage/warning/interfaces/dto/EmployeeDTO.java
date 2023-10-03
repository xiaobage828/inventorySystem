package cn.xiaobage.warning.interfaces.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeDTO {

    String empId;

    String empName;

    BigDecimal salary;
}
