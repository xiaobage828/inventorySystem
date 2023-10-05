package cn.xiaobage.personnel;

import cn.xiaobage.personnel.domain.employee.repository.facade.EmployeeRepository;
import cn.xiaobage.personnel.domain.employee.repository.po.EmployeePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonnelApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
        EmployeePO employeePO  = employeeRepository.queryEmployeeByEmpId("1");
        System.out.println(employeePO);
    }

}
