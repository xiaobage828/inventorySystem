package cn.xiaobage.personnel.domain.organization.repository.mapper;

import cn.xiaobage.personnel.domain.employee.repository.po.EmployeePO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationMapper extends BaseMapper<EmployeePO> {
}
