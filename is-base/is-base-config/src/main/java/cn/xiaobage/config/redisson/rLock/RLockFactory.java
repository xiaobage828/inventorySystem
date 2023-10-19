package cn.xiaobage.config.redisson.rLock;

import org.redisson.api.RLock;

public interface RLockFactory {

    RLock  getRLock(Object[] parameters);

}
