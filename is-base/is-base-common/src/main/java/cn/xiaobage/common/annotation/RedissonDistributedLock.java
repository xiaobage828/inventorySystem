package cn.xiaobage.common.annotation;

import cn.xiaobage.config.redisson.key.KeyType;
import cn.xiaobage.config.redisson.rLock.RLockType;
import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;


/**
 * @author xiaobage
 * @package cn.xiaobage.common.annotation
 * @createTime 2023/10/18 - 21:53
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RedissonDistributedLock {

    String redissonClient() default "redisson";

    RLockType rlockType() default RLockType.REDISSON_LOCK;

    String keyPrefix() default "lock:";

    KeyType keyType() default KeyType.EXPRESSION;

    /** 锁的key */
    String key() default "" ;


    /** 超时时间 */
    long timeout() default -1L;

    /** 时间单位 */
    TimeUnit unit() default TimeUnit.SECONDS;


}
