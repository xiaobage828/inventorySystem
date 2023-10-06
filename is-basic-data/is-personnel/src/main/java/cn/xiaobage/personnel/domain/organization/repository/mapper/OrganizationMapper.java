package cn.xiaobage.personnel.domain.organization.repository.mapper;

import cn.xiaobage.personnel.domain.employee.repository.po.EmployeePO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationMapper extends BaseMapper<EmployeePO> {
}
