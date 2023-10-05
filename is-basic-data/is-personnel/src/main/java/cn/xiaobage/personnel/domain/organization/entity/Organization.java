package cn.xiaobage.personnel.domain.organization.entity;

import cn.xiaobage.personnel.domain.employee.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class Organization {

    String id;

    String name;

    Organization parentOrg;

    List<Organization> sonOrgs;

    List<Employee> currentEmp;

}
