package cn.xiaobage.personnel.domain.organization.repository.po;

import cn.xiaobage.personnel.domain.organization.entity.Organization;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)//开启链式调用
@TableName(value="organization")//默认将类名作为表名
public class OrganizationPO {

    @TableId(value = "id",type = IdType.AUTO)//代表当前属性映射数据库主键
    String id;

    String name;

    String parentId;

    OrganizationPO parentOrg;
}
