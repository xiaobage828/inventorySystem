package cn.xiaobage.domainEvent.domain.domainEvent.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//@Getter
//@Setter
@Data
public class DomainEvent {

    private Long id;

    private Date time;

    private String serverName;

    private String className;

    private String data;
}
