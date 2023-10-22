package cn.xiaobage.inventory.application.service;


import cn.xiaobage.common.annotation.RedissonDistributedLock;
import cn.xiaobage.config.api.Response;
import cn.xiaobage.config.redisson.key.KeyType;
import cn.xiaobage.config.redisson.rLock.RLockType;
import cn.xiaobage.config.util.RedisUtil;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.event.InventoryCreateEvent;
import cn.xiaobage.inventory.domain.inventory.service.InventoryDomainService;
import cn.xiaobage.inventory.infrastructure.client.DomainEventFeignClient;
import cn.xiaobage.inventory.infrastructure.common.action.InventoryCreateTccAction;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisKeyPrefixConst;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisOpsInventory;
import cn.xiaobage.inventory.interfaces.assembler.DomainEventAssembler;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.transaction.TransactionHookAdapter;
import io.seata.tm.api.transaction.TransactionHookManager;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class InventoryApplicationService {

    @Autowired
    InventoryDomainService inventoryDomainService;


    @Autowired
    ApplicationContext applicationContext;


    @Autowired
    DomainEventFeignClient domainEventFeignClient;

    @Autowired
    RedisOpsInventory redisOpsInventory;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    InventoryCreateTccAction inventoryCreateTccActionImpl;


    public List<Inventory> queryInventory(Long inventoryId, Long warehouseId, Long productId){
        return inventoryDomainService.queryInventory(inventoryId,warehouseId,productId);
    }

    public Inventory queryInventoryByIdFromDB(Long inventoryId){
        return inventoryDomainService.queryInventoryById(inventoryId);
    }

    public Inventory queryInventoryByIdFromCacheAndDB(Long inventoryId){

        Inventory inventory = redisOpsInventory.queryInventoryByIdFromCache(inventoryId);

        if(inventory != null){
            return inventory;
        }

        inventory = ((InventoryApplicationService)AopContext.currentProxy()).queryInventoryAndSetCacheById(inventoryId);

        return inventory;
    }

    @RedissonDistributedLock(redissonClient = "redisson",rlockType = RLockType.REDISSON_LOCK,keyPrefix = RedisKeyPrefixConst.InventoryHotKeyCreateLock,keyType = KeyType.EXPRESSION,key = "#inventoryId")
    public Inventory queryInventoryAndSetCacheById(Long inventoryId){

        Inventory inventory = redisOpsInventory.queryInventoryByIdFromCache(inventoryId);

        if(inventory != null){
            return inventory;
        }

        inventory = ((InventoryApplicationService)AopContext.currentProxy()).findInventoryFromDBAndSetCacheById(inventoryId);

        return inventory;
    }

    @RedissonDistributedLock(redissonClient = "redisson",rlockType = RLockType.REDISSON_READ_LOCK,keyPrefix = RedisKeyPrefixConst.InventoryLock ,keyType = KeyType.EXPRESSION,key = "#inventoryId")

    public Inventory findInventoryFromDBAndSetCacheById(Long inventoryId){

        Inventory inventory = queryInventoryByIdFromDB(inventoryId);

        if(inventory != null){

            redisOpsInventory.saveInventory(inventory);

            return inventory;
        }

        inventory = redisOpsInventory.saveEmptyInventory(inventoryId , Inventory.NULL_INVENTORY);

        stringRedisTemplate.expire(RedisKeyPrefixConst.InventoryCache + inventoryId , RedisUtil.getEmptyTimeOut(), TimeUnit.SECONDS );

        return inventory;
    }


    @GlobalTransactional(rollbackFor = Exception.class)
    public int createInventory(Inventory inventory){
        int updateRecord = inventoryDomainService.createInventory(inventory);
        if(updateRecord > 0){

            inventoryCreateTccActionImpl.prepareInventoryCreate(null, inventory.getId(), inventory);

            InventoryCreateEvent inventoryCreateEvent = InventoryCreateEvent.create(inventory);

            Response response = domainEventFeignClient.save(DomainEventAssembler.toDTO(inventoryCreateEvent));

            TransactionHookManager.registerHook(new TransactionHookAdapter(){
                @Override
                public void afterCommit() {
                    applicationContext.publishEvent(inventoryCreateEvent);
                }
            });

        }

        return updateRecord;
    }

    public int inventoryIncrement(Long inventoryId, Integer quantity, Date updateTime){
        return inventoryDomainService.inventoryIncrement(inventoryId,quantity,updateTime);
    }

    public int inventoryDecrement(Long inventoryId, Integer quantity, Date updateTime ){
        return inventoryDomainService.inventoryDecrement(inventoryId,quantity,updateTime);
    }

}
