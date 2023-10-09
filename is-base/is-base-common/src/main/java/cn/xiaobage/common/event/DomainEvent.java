package cn.xiaobage.inventory.infrastructure.common.event;

import lombok.Data;

import java.util.Date;

@Data
public class DomainEvent {

    private Long id;

    private Date time;

    private String serverName;

    private String className;

    private String data;
}
