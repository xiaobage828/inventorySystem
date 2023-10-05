package cn.xiaobage.domainEvent.domain.domainEvent.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 领域事件
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("domain_event")
@ApiModel(value = "DomainEventPO对象", description = "领域事件")
public class DomainEventPO implements Serializable {


    private static final long serialVersionUID = -5129974370382064051L;

    @ApiModelProperty("领域事件ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("事件发生的时间")
    @TableField("time")
    private Date time;

    @ApiModelProperty("服务名")
    @TableField("server_name")
    private String serverName;

    @ApiModelProperty("类名")
    @TableField("class_name")
    private String className;

    @ApiModelProperty("领域事件对象JSON字符串")
    @TableField("data")
    private String data;


}
