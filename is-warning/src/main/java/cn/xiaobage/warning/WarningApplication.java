package cn.xiaobage.warning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableFeignClients(basePackages = "cn.xiaobage.warning.infrastructure.client")
@EnableTransactionManagement
@ComponentScan("cn.xiaobage")
@EnableDiscoveryClient
@MapperScan("cn.xiaobage.warning.domain.**.mapper")
@SpringBootApplication
public class WarningApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarningApplication.class, args);
    }

}
