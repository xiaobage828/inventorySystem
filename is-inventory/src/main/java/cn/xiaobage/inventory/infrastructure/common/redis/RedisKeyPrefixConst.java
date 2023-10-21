package cn.xiaobage.inventory.infrastructure.common.redis;

public class RedisKeyPrefixConst {

    public static final String InventoryCache = "inventory_management:inventory:";

    public static final String InventoryLock = "lock:read:" + InventoryCache;

}
