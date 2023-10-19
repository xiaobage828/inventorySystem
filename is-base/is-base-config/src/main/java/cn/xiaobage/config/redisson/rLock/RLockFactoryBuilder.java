package cn.xiaobage.config.redisson.rLock;

import org.redisson.api.RedissonClient;

public class RLockFactoryBuilder {

    protected RLockType defaultRLockType = RLockType.REDISSON_LOCK;


    public RLockFactory newRLockFactory(RedissonClient redissonClient, RLockType rLockType){

        rLockType = null == rLockType ? defaultRLockType : rLockType;

        if(rLockType == RLockType.REDISSON_LOCK){
            return new RedissonLockFactory(redissonClient);
        }

        if(rLockType == RLockType.REDISSON_READ_LOCK){
            return new RedissonReadLockFactory(redissonClient);
        }

        if(rLockType == RLockType.REDISSON_WRITE_LOCK){
            return new RedissonWriteLockFactory(redissonClient);
        }

        return new RedissonLockFactory(redissonClient);

    }

}
