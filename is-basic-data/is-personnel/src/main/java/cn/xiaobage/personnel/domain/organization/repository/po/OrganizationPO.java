package cn.xiaobage.personnel.domain.organization.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)//开启链式调用
@TableName(value="organization")//默认将类名作为表名
public class OrganizationPO implements Serializable {

    private static final long serialVersionUID = -8715742928030459853L;

    @TableId(value = "id",type = IdType.AUTO)//代表当前属性映射数据库主键
    String id;

    String name;

    String parentId;

    OrganizationPO parentOrg;
}
