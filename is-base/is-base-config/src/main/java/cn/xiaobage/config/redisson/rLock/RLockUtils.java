package cn.xiaobage.config.redisson.rLock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class RLockUtils {

    public static RLock getRLock(RedissonClient redissonClient, RLockType rLockType, Object[] parameters){
        return new RLockFactoryBuilder().newRLockFactory(redissonClient,rLockType).getRLock(parameters);
    }
}
