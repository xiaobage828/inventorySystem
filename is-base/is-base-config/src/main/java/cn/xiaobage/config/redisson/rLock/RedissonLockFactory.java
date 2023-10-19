package cn.xiaobage.config.redisson.rLock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class RedissonLockFactory extends BaseRLockFactory{


    public RedissonLockFactory(RedissonClient redissonClient) {
        super(redissonClient);
    }


    @Override
    protected RLock processGetRLock(Object[] parameters) {
        return getRedissonClient().getLock((String) parameters[0]);
    }
}
