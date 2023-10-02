package cn.xiaobage.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author xiaobage
 * @package cn.xiaobage.common.annotation
 * @createTime 2023/10/01 - 15:42
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@RestController // 组合
public @interface ResponseResult {
    // 是否忽略
    boolean ignore() default false;
}
