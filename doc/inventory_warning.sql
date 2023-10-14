/**
  库存预警库，暂设计为inventory_warning库，包括三张表
  inventory_warning_configuration
  warning_record
  *
 */
DROP DATABASE  IF EXISTS inventory_warning;

CREATE DATABASE inventory_warning CHARSET utf8mb4;

USE inventory_warning;

DROP TABLE IF EXISTS `inventory_warning_configuration`;

CREATE TABLE inventory_warning_configuration (
    inventory_id BIGINT(64) PRIMARY KEY COMMENT '库存ID',
    minimum_inventory INT(11) NOT NULL DEFAULT 0 COMMENT '最小库存',
    maximum_inventory INT(11)  COMMENT '最大库存',
    units VARCHAR(100) NOT NULL COMMENT '计量单位',
    warning_person INT(11) NOT NULL COMMENT '预警人，来自employee表的emp_id',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '修改时间',
    KEY `idx_warning_person` (`warning_person`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='库存预警配置';

DROP TABLE IF EXISTS `warning_record`;

CREATE TABLE warning_record (
    id BIGINT(64) PRIMARY KEY COMMENT '预警记录ID',
    inventory_id BIGINT(64) COMMENT '库存ID',
    current_inventory INT(11) NOT NULL COMMENT '当前库存',
    minimum_inventory INT(11) NOT NULL DEFAULT 0 COMMENT '最小库存',
    maximum_inventory INT(11)  COMMENT '最大库存',
    units VARCHAR(100) NOT NULL COMMENT '计量单位',
    warning_person INT(11) NOT NULL COMMENT '预警人，来自employee表的emp_id',
    warning_time DATETIME NOT NULL COMMENT '预警时间',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    KEY `idx_inventory_id` (`inventory_id`),
    KEY `idx_warning_person` (`warning_person`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='预警记录';



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