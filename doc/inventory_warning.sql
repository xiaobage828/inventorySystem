/**
  库存预警库，暂设计为inventory_warning库，包括三张表
  inventory_warning_configuration
  warning_record
  *
 */
DROP DATABASE  IF EXISTS inventory_warning;

CREATE DATABASE inventory_warning CHARSET utf8mb4;

USE inventory_warning;

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