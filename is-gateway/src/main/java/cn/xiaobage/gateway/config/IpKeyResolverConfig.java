package cn.xiaobage.gateway.config;

import cn.xiaobage.gateway.resolver.IpKeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IpKeyResolverConfig {

    @Bean("ipKeyResolver")
    public IpKeyResolver ipKeyResolver(){
        return new IpKeyResolver();
    }
}
