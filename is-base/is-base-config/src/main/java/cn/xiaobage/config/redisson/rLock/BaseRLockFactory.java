package cn.xiaobage.config.redisson.rLock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public abstract class BaseRLockFactory implements RLockFactory{

    protected RedissonClient redissonClient;

    public BaseRLockFactory(RedissonClient redissonClient){
        this.redissonClient = redissonClient;
    }

    @Override
    public RLock getRLock(Object[] parameters){
        beforeProcessGetRLock(parameters);
        RLock rLock = processGetRLock(parameters);
        return afterProcessGetRLock(rLock);
    }

    protected void beforeProcessGetRLock(Object[] parameters){

    }
    abstract protected RLock processGetRLock(Object[] parameters);

    protected RLock afterProcessGetRLock(RLock rLock){
        return rLock;
    }


    public RedissonClient getRedissonClient() {
        return redissonClient;
    }
}
