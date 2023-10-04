/**
  共享领域事件库
 */
DROP DATABASE  IF EXISTS domain_event;

CREATE DATABASE domain_event CHARSET utf8mb4;

USE domain_event;

CREATE TABLE domain_event (
    id BIGINT(64) PRIMARY KEY COMMENT '领域事件ID',
    time DATE NOT NULL COMMENT '事件发生的时间',
    server_name VARCHAR(50) NOT NULL COMMENT '服务名',
    class VARCHAR(120) NOT NULL COMMENT '类名',
    data JSON NOT NULL COMMENT '领域事件对象JSON字符串',
    KEY `idx_server_name_class` (`server_name`,`class`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='领域事件';