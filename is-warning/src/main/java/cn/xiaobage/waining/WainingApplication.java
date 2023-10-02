package cn.xiaobage.waining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class WainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WainingApplication.class, args);
    }

}
