/**
  库存管理库，暂设计为inventory_management库，包括三张表
  inventory
  warehouse_in_record
  outbound_delivery_order
  *
 */
DROP DATABASE  IF EXISTS inventory_management;

CREATE DATABASE inventory_management CHARSET utf8mb4;

USE inventory_management;

CREATE TABLE inventory (
    id BIGINT(64) PRIMARY KEY COMMENT '库存ID',
    warehouse_id BIGINT(64) COMMENT '仓库ID',
    product_id BIGINT(64)  COMMENT '产品ID',
    total_quantity INT(11) NOT NULL DEFAULT 0 COMMENT '剩余库存',
    lock_quantity INT(11) NOT NULL DEFAULT 0 COMMENT '锁定库存',
    damaged_quantity INT(11) NOT NULL DEFAULT 0 COMMENT '损坏库存',
    minimum_inventory INT(11) NOT NULL DEFAULT 0 COMMENT '最小库存',
    maximum_inventory INT(11)  COMMENT '最大库存',
    units VARCHAR(100) NOT NULL COMMENT '计量单位',
    create_time DATE NOT NULL COMMENT '创建时间',
    update_time DATE NOT NULL COMMENT '修改时间',
    UNIQUE KEY `uq_warehouse_id_product_id` (`warehouse_id`,`product_id`),
    KEY `idx_product_id` (`product_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='库存';


CREATE TABLE warehouse_in_record (
    id BIGINT(64) PRIMARY KEY COMMENT '入库单ID',
    record_code VARCHAR(30) COMMENT '单据流水号',
    inventory_id BIGINT(64) COMMENT '库存ID，来自inventory表的id字段',
    tag VARCHAR(200) COMMENT '入库标签',
    quantity INT(11) NOT NULL DEFAULT 1 COMMENT '入库数量',
    units VARCHAR(30) NOT NULL COMMENT '计量单位',
    remark TINYTEXT COMMENT '备注',
    trader VARCHAR(200) COMMENT '交易方',
    trading_time DATE NOT NULL COMMENT '交易时间',
    time_of_making DATE NOT NULL COMMENT '单据制作时间',
    maker INT(11) NOT NULL  COMMENT '制单人，来自employee表的emp_id',
    create_time DATE NOT NULL COMMENT '创建时间',
    UNIQUE KEY `uq_record_code` (`record_code`),
    KEY `idx_inventory_id` (`inventory_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='入库单';



CREATE TABLE outbound_delivery_order (
    id BIGINT(64) PRIMARY KEY COMMENT '存库单ID',
    record_code VARCHAR(30) COMMENT '单据流水号',
    inventory_id BIGINT(64) COMMENT '库存ID，来自inventory表的id字段',
    tag VARCHAR(200) COMMENT '存库标签',
    quantity INT(11) NOT NULL DEFAULT 1 COMMENT '存库数量',
    units VARCHAR(30) NOT NULL COMMENT '计量单位',
    remark TINYTEXT COMMENT '备注',
    trader VARCHAR(200) COMMENT '交易方',
    trading_time DATE NOT NULL COMMENT '交易时间',
    time_of_making DATE NOT NULL COMMENT '单据制作时间',
    maker INT(11) NOT NULL  COMMENT '制单人，来自employee表的emp_id',
    create_time DATE NOT NULL COMMENT '创建时间',
    UNIQUE KEY `uq_record_code` (`record_code`),
    KEY `idx_inventory_id` (`inventory_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='出库单';