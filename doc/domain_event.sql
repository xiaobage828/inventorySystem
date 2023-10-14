/**
  共享领域事件库
 */
DROP DATABASE  IF EXISTS domain_event;

CREATE DATABASE domain_event CHARSET utf8mb4;

USE domain_event;

DROP TABLE IF EXISTS domain_event;

CREATE TABLE domain_event (
    id BIGINT(64) PRIMARY KEY COMMENT '领域事件ID',
    `time` DATETIME NOT NULL COMMENT '事件发生的时间',
    server_name VARCHAR(50) NOT NULL COMMENT '服务名',
    class_name VARCHAR(120) NOT NULL COMMENT '类名',
    data JSON NOT NULL COMMENT '领域事件对象JSON字符串',
    KEY `idx_server_name_class_name` (`server_name`,`class_name`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='领域事件';



DROP TABLE IF EXISTS `undo_log`;

-- 注意此处0.3.0+ 增加唯一索引 ux_undo_log
CREATE TABLE `undo_log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id` bigint(20) NOT NULL,
    `xid` varchar(100) NOT NULL,
    `context` varchar(128) NOT NULL,
    `rollback_info` longblob NOT NULL,
    `log_status` int(11) NOT NULL,
    `log_created` datetime NOT NULL,
    `log_modified` datetime NOT NULL,
    `ext` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='Seata AT 模式使用到的undo_log表';