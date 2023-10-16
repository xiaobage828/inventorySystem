package cn.xiaobage.domainEvent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableTransactionManagement
@ComponentScan("cn.xiaobage")
@MapperScan("cn.xiaobage.domainEvent.domain.**.mapper")
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DomainEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainEventApplication.class, args);
    }

    @GetMapping("/health")
    public String health(){
        return "is-domain-event";
    }

}
