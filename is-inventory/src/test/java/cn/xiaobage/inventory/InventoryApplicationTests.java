package cn.xiaobage.inventory;


import cn.xiaobage.config.util.FileLoad;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisKeyPrefixConst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
class InventoryApplicationTests {

    private static String inventoryQueryLua;

    @Resource
    RedisTemplate redisTemplate;

    static {
        inventoryQueryLua = FileLoad.read("lua/inventory_query.lua");
    }


    @Test
    void contextLoads() {
        RedisScript redisScript = new DefaultRedisScript(inventoryQueryLua);
        redisTemplate.execute(redisScript, Collections.singletonList(RedisKeyPrefixConst.InventoryCache + "1710905624312717312"),0);;
    }

}
