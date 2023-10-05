package cn.xiaobage.personnel.domain.employee.repository.po;

import cn.xiaobage.personnel.domain.organization.repository.po.OrganizationPO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)//开启链式调用
@TableName(value="employee")//默认将类名作为表名
public class EmployeePO implements Serializable {

    private static final long serialVersionUID = 8049940651228382410L;
    @TableId(value = "emp_id",type = IdType.AUTO)//代表当前属性映射数据库主键
    String empId;

    String empName;

    String orgId;

    BigDecimal salary;

    @TableField(exist = false)
    OrganizationPO organization;
}
