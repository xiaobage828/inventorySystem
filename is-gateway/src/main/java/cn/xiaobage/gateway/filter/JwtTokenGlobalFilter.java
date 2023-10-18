package cn.xiaobage.gateway.filter;

import cn.xiaobage.config.api.Response;
import cn.xiaobage.config.exception.IsException;
import cn.xiaobage.config.util.JwtUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


/**
 * @author xiaobage
 * @package cn.xiaobage.gateway.filter
 * @createTime 2023/10/16 - 15:38
 * @description
 */
@Slf4j
@Component
@Order(-100)
@Data
@ConfigurationProperties(prefix = "is.global-filter")
public class JwtTokenGlobalFilter implements GlobalFilter {

    private final ObjectMapper objectMapper;

    public JwtTokenGlobalFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 忽略认证url
     */
    private Set<String> ignoreUrlSet;

    /**
     * 认证标识
     */
    private String authorization;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求url
        // http://127.0.0.1:7210/ld-lucky/v1/user/login
        String url = exchange.getRequest().getURI().getPath();

        // 忽略认证
        for (String ignoreUrl : ignoreUrlSet) {
            if (ignore(url, ignoreUrl)) {
                return chain.filter(exchange);
            }
        }

        // 认证逻辑
        String token = exchange.getRequest().getHeaders().getFirst(authorization);
        ServerHttpResponse resp = exchange.getResponse();

        try {
            Map<String, Object> userMap = JwtUtil.verifyToken(token);
            ServerHttpRequest.Builder mutate = exchange.getRequest().mutate();
            mutate.header("name", URLEncoder.encode(Objects.isNull(userMap.get("name")) ? "" : userMap.get("name").toString()), "UTF-8");
            mutate.header("username", URLEncoder.encode(Objects.isNull(userMap.get("username")) ? "" : userMap.get("username").toString()), "UTF-8");
            mutate.header("id", Objects.isNull(userMap.get("id")) ? "0" : userMap.get("id").toString());
            mutate.header("phone", Objects.isNull(userMap.get("phone")) ? "" : userMap.get("phone").toString());
            return chain.filter(exchange.mutate().request(mutate.build()).build());
        } catch (Exception e) {
            //错误处理
            log.error("token认证失败：", e);
            // 写一个统一错误JSON出去
            return autoError(resp, "认证出错，请重新登录！");
        }
    }

    private Mono<Void> autoError(ServerHttpResponse resp, String msg) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");

        String returnStr = "";
        try {
            returnStr = objectMapper.writeValueAsString(Response.failed(msg));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));

        return resp.writeWith(Flux.just(buffer));
    }


    /**
     * 忽略逻辑
     * 1、判断字符串存在（当前使用）
     * 2、用正则
     * 3、相似度算法（99%）
     *
     * @param url       ：请求url
     * @param ignoreUrl ： 忽略url
     * @return
     */
    private Boolean ignore(String url, String ignoreUrl) {
        if (Objects.isNull(url)) {
            throw new IsException("请求 url 有误！");
        }
        return url.contains(ignoreUrl);
    }

}
