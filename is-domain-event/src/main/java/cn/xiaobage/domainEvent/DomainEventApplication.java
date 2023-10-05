package cn.xiaobage.domainEvent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@ComponentScan("cn.xiaobage")
@MapperScan("cn.xiaobage.domainEvent.domain.**.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class DomainEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainEventApplication.class, args);
    }

}
