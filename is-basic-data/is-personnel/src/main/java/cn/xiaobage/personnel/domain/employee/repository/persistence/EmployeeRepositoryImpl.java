package cn.xiaobage.personnel.domain.employee.repository.persistence;

import cn.xiaobage.personnel.domain.employee.repository.facade.EmployeeRepository;
import cn.xiaobage.personnel.domain.employee.repository.mapper.EmployeeMapper;
import cn.xiaobage.personnel.domain.employee.repository.po.EmployeePO;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public EmployeePO queryEmployeeByEmpId(String empId) {
        return employeeMapper.selectById(empId);
    }

    @Override
    public List<EmployeePO> queryCurEmployeeByOrgId(String orgId) {
        QueryWrapper<EmployeePO> wrapper = new QueryWrapper<>();
        wrapper.eq("org_id",orgId);
        return employeeMapper.selectList(wrapper);
    }


}
