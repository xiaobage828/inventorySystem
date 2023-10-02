package cn.xiaobage.common.interceptor;

import cn.xiaobage.config.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author xiaobage
 * @package cn.xiaobage.common.interceptor
 * @createTime 2023/10/02 - 23:13
 * @description
 */
@Slf4j
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> userMap = new HashMap<>();

        String name = URLDecoder.decode(Objects.isNull(request.getHeader("name")) ? "" : request.getHeader("name"), "UTF-8");
        String username = URLDecoder.decode(Objects.isNull(request.getHeader("username")) ? "" : request.getHeader("username"), "UTF-8");
        String id = request.getHeader("id");
        String phone = request.getHeader("phone");

        userMap.put("name", name);
        userMap.put("username", username);
        userMap.put("id", id);
        userMap.put("phone", phone);

        SecurityUtil.addConfig(userMap);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        SecurityUtil.remove();
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
