/**
    Basic Data should include product, customer, supplier, warehouse, personnel, finance.
    This just designs  personnel, product, warehouse.
*/



/**
  一、人员领域，暂设计为personnel库，包括两张表
  1. employee
  2. organization
 */
DROP DATABASE  IF EXISTS personnel;

CREATE DATABASE personnel CHARSET utf8mb4;

USE personnel;


DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    emp_id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '员工ID',
    emp_name VARCHAR(120) NOT NULL COMMENT '员工姓名',
    org_id INT(11) NOT NULL COMMENT '组织机构ID',
    salary DECIMAL NOT NULL COMMENT '薪水',
    KEY `idx_org_id` (`org_id`)
)ENGINE=INNODB  AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='员工信息表';

insert into `employee` (`emp_id`, `emp_name`, `org_id`, `salary`) values('1','小明','1','13000');
insert into `employee` (`emp_id`, `emp_name`, `org_id`, `salary`) values('2','小方','1','12000');
insert into `employee` (`emp_id`, `emp_name`, `org_id`, `salary`) values('3','小邓','2','14000');


DROP TABLE IF EXISTS organization;

CREATE TABLE organization (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '组织机构ID',
    `name` VARCHAR(120) NOT NULL COMMENT '组织名称',
    path TINYTEXT NOT NULL COMMENT '组织路径',
    parent_org_id INT COMMENT '父级组织ID',
    KEY `idx_parent_org_id` (`parent_org_id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='组织机构表';

/**
  二、产品领域，暂设计为product_info库，包括三张表
  product
  brand
  category
 */
DROP DATABASE  IF EXISTS product_info;

CREATE DATABASE product_info CHARSET utf8mb4;

USE product_info;

DROP TABLE IF EXISTS product;

CREATE TABLE `product` (
    `id` BIGINT(64) NOT NULL COMMENT '产品ID',
    `sale_status` TINYINT(1) NOT NULL COMMENT '销售状态 1上架 2下架',
    `img_url` TEXT COMMENT '图片路径',
    `pro_no` VARCHAR(20) NOT NULL COMMENT '商品编码',
    `brand_id` BIGINT(64) NOT NULL COMMENT '品牌id',
    `category_id` BIGINT(64) NOT NULL COMMENT '分类id',
    `product_name` VARCHAR(256) NOT NULL COMMENT '商品名称',
    `cost_price` DECIMAL COMMENT '成本价',
    `wholesale_price` DECIMAL COMMENT  '批发价',
    `retail_price` DECIMAL COMMENT '零售价',
    `description` TEXT COMMENT '商品描述',
    `create_time` DATE COMMENT '创建时间',
    `update_time` DATE COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uq_pro_no` (`pro_no`),
    KEY `idx_brand_id` (`brand_id`),
    KEY `idx_category_id` (`category_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='产品信息表';



DROP TABLE IF EXISTS brand;

CREATE TABLE `brand` (
    `id` bigint(64) NOT NULL COMMENT '品牌ID',
    `brand_cn_name` varchar(128) NOT NULL COMMENT '品牌中文名',
    `brand_en_name` varchar(128) NOT NULL COMMENT '品牌英文名',
    `logo_url` text COMMENT '品牌Logo',
    `brand_story` text COMMENT '品牌故事',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌表';



DROP TABLE IF EXISTS category;

CREATE TABLE `category` (
    `id` bigint(64) NOT NULL COMMENT '类目ID',
    `category_name` varchar(128) NOT NULL COMMENT '类目名称',
    `parent_category_id` bigint(64) NOT NULL COMMENT '父级分类ID',
    PRIMARY KEY (`id`),
    KEY `idx_parent_category_id` (`parent_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目表';



/**
  三、仓库领域，暂设计为warehouse库，包括一个表
  warehouse
 */
DROP DATABASE  IF EXISTS warehouse;

CREATE DATABASE warehouse CHARSET utf8mb4;

USE warehouse;

CREATE TABLE warehouse (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '仓库ID',
    `name` VARCHAR(120) NOT NULL COMMENT '仓库名称',
    `address` VARCHAR(200) NOT NULL COMMENT '仓库地址',
    `person_in_charge` INT(11) NOT NULL COMMENT '负责人，来自employee表的emp_id',
    parent_warehouse_id INT COMMENT '父级仓库ID',
    KEY `idx_parent_warehouse_id` (`parent_warehouse_id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='仓库信息';