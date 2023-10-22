package cn.xiaobage.inventory.infrastructure.common.redis;

public class RedisKeyPrefixConst {

    public static final String InventoryCache = "inventory_management:inventory:";

    public static final String InventoryLock = "lock:" + InventoryCache;

    public static final String InventoryHotKeyCreateLock = "lock:hot_key_create:" + InventoryCache;

}
