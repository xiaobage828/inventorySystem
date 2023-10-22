package cn.xiaobage.personnel;

import cn.xiaobage.config.api.Response;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAspectJAutoProxy(exposeProxy = true)
@RestController
@EnableFeignClients(basePackages = "cn.xiaobage.personnel.infrastructure.client")
@EnableTransactionManagement
@ComponentScan("cn.xiaobage")
@EnableDiscoveryClient
@MapperScan("cn.xiaobage.personnel.domain.**.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PersonnelApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonnelApplication.class, args);
    }

    @GetMapping("/health")
    public Response health(){
        return Response.ok("is-personnel");
    }

}
