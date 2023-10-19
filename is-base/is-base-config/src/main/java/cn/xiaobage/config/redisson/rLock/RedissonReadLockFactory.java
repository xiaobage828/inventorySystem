package cn.xiaobage.config.redisson.rLock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class RedissonReadLockFactory extends BaseRLockFactory{


    public RedissonReadLockFactory(RedissonClient redissonClient) {
        super(redissonClient);
    }

    @Override
    protected RLock processGetRLock(Object[] parameters) {
        return  redissonClient.getReadWriteLock((String) parameters[0]).readLock();
    }
}
