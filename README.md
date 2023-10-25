# inventorySystem/库存管理系统
这个系统算是一个比较大的项目了，主体功能就是库存管理和库存预警，但在开发该系统时我实现了DDD架构来搭建系统框架。

本系统主要涉及模块有：
1. 基础资料模块(is-basic-data)
   - 员工信息模块(is-personnel)
   - 产品模块(is-product)
   - 仓库模块(is-warehouse)
2. 库存模块(is-inventory)
3. 库存预警模块(is-warning)
4. 领域事件模块(is-domain-event)

技术：
后端：JDK8、Spring Boot2.5.0、Spring Cloud Alibaba(nacos、loadbalancer、openfeign、seata、gateway、sentinel、sleuth、zipkin)、mybatis-plus、mybatis、RocketMQ、Redis、MySQL
