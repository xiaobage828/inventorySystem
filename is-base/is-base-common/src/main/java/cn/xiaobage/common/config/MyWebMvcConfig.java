package cn.xiaobage.common.config;

import cn.xiaobage.common.interceptor.SecurityInterceptor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author J3
 * @package cn.xiaobage.bldbase.config
 * @createTime 2022/11/1 - 16:22
 * @description
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class MyWebMvcConfig implements WebMvcConfigurer {

    private final SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login", "/**/register");
    }
}
