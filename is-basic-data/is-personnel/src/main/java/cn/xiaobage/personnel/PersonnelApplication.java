package cn.xiaobage.personnel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients(basePackages = "cn.xiaobage.personnel.infrastructure.client")
@EnableTransactionManagement
@ComponentScan("cn.xiaobage")
@EnableDiscoveryClient
@MapperScan("cn.xiaobage.personnel.domain.**.mapper")
@SpringBootApplication
public class PersonnelApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonnelApplication.class, args);
    }

}
