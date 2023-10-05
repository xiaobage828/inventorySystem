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

insert into `organization` (`id`, `name`, `path`, `parent_org_id`) values('1','总公司','1',NULL);
insert into `organization` (`id`, `name`, `path`, `parent_org_id`) values('2','总部','1.2','1');
insert into `organization` (`id`, `name`, `path`, `parent_org_id`) values('3','北京分公司','1.3','1');
insert into `organization` (`id`, `name`, `path`, `parent_org_id`) values('40','财务处','1.2.40','2');
insert into `organization` (`id`, `name`, `path`, `parent_org_id`) values('41','宣传部','1.2.41','2');

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
    `create_time` DATETIME COMMENT '创建时间',
    `update_time` DATETIME COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uq_pro_no` (`pro_no`),
    KEY `idx_brand_id` (`brand_id`),
    KEY `idx_category_id` (`category_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='产品信息表';

insert  into `product`(`id`,`sale_status`,`img_url`,`pro_no`,`brand_id`,`category_id`,`product_name`,`cost_price`,`wholesale_price`,`retail_price`,`description`,`create_time`,`update_time`) values
 (1709909767127900166,1,NULL,'1709909767127900166',1709909767127900163,1709909767127900162,'华为mate60',NULL,NULL,NULL,NULL,'2023-10-05 20:41:22','2023-10-05 20:41:26'),
 (1709909767127900167,1,NULL,'1709909767127900167',1709909767127900163,1709909767127900162,'华为mate60 PRO',NULL,NULL,NULL,NULL,'2023-10-05 20:41:22','2023-10-05 20:41:26');


DROP TABLE IF EXISTS brand;

CREATE TABLE `brand` (
    `id` bigint(64) NOT NULL COMMENT '品牌ID',
    `brand_cn_name` varchar(128) NOT NULL COMMENT '品牌中文名',
    `brand_en_name` varchar(128) NOT NULL COMMENT '品牌英文名',
    `logo_url` text COMMENT '品牌Logo',
    `brand_story` text COMMENT '品牌故事',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌表';

insert  into `brand`(`id`,`brand_cn_name`,`brand_en_name`,`logo_url`,`brand_story`) values
(1709909767127900163,'华为','HUAWEI',NULL,NULL),
(1709909767127900164,'TCL','TCL',NULL,NULL);



DROP TABLE IF EXISTS category;

CREATE TABLE `category` (
    `id` bigint(64) NOT NULL COMMENT '类目ID',
    `category_name` varchar(128) NOT NULL COMMENT '类目名称',
    `parent_category_id` bigint(64) COMMENT '父级分类ID',
    PRIMARY KEY (`id`),
    KEY `idx_parent_category_id` (`parent_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目表';

insert  into `category`(`id`,`category_name`,`parent_category_id`) values
(1709908788642902016,'生鲜',0),
(1709909267263324160,'水果',1709908788642902016),
(1709909767123705856,'西瓜',1709909267263324160),
(1709909767127900160,'电子设备',0),
(1709909767127900161,'通讯设备',1709909767127900160),
(1709909767127900162,'手机',1709909767127900161);


/**
  三、仓库领域，暂设计为warehouse库，包括一个表
  warehouse
 */
DROP DATABASE  IF EXISTS warehouse;

CREATE DATABASE warehouse CHARSET utf8mb4;

USE warehouse;

CREATE TABLE warehouse (
    id bigint(64) PRIMARY KEY COMMENT '仓库ID',
    `name` VARCHAR(120) NOT NULL COMMENT '仓库名称',
    `address` VARCHAR(200) NOT NULL COMMENT '仓库地址',
    `person_in_charge` INT(11) NOT NULL COMMENT '负责人，来自employee表的emp_id',
    parent_warehouse_id bigint(64) COMMENT '父级仓库ID',
    KEY `idx_parent_warehouse_id` (`parent_warehouse_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='仓库信息';

insert into `warehouse` (`id`, `name`, `address`, `person_in_charge`, `parent_warehouse_id`) values('1709906292365123584','深圳总仓','深圳南山区前海','1',NULL);
insert into `warehouse` (`id`, `name`, `address`, `person_in_charge`, `parent_warehouse_id`) values('1709906746608316416','南山分仓','深圳南山区前海','1','1709906292365123584');
insert into `warehouse` (`id`, `name`, `address`, `person_in_charge`, `parent_warehouse_id`) values('1709907118101962752','宝安分仓','深圳南山区西厢街道','1','1709907118101962752');
