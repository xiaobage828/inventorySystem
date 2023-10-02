/**
    Basic Data should include product, customer, supplier, warehouse, personnel, finance.
    This just designs  personnel, product, warehouse.
*/



/**
  一、人员领域，暂设计为personnel库，包括两个表
  1. employee
  2. organization
 */
DROP DATABASE  IF EXISTS personnel;

CREATE DATABASE personnel;

USE personnel;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    empId INT(11) PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(120) NOT NULL,
    orgId INT(11) NOT NULL,
    salary DECIMAL NOT NULL
);

DROP TABLE IF EXISTS organization;

CREATE TABLE organization (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(120) NOT NULL,
    parent_id INT
);








/**
  产品领域，暂以product表代替
  table product
 */



/**
  仓库领域，暂以warehouse表代替
  table warehouse
 */