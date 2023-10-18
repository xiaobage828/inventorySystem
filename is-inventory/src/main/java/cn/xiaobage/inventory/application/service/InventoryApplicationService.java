package cn.xiaobage.inventory.application.service;


import cn.xiaobage.config.api.Response;
import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import cn.xiaobage.inventory.domain.inventory.event.InventoryCreateEvent;
import cn.xiaobage.inventory.domain.inventory.service.InventoryDomainService;
import cn.xiaobage.inventory.infrastructure.client.DomainEventFeignClient;
import cn.xiaobage.inventory.infrastructure.common.action.InventoryCreateTccAction;
import cn.xiaobage.inventory.infrastructure.common.redis.RedisOpsInventory;
import cn.xiaobage.inventory.interfaces.assembler.DomainEventAssembler;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.transaction.TransactionHookAdapter;
import io.seata.tm.api.transaction.TransactionHookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

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
    InventoryCreateTccAction inventoryCreateTccActionImpl;


    public List<Inventory> queryInventory(Long inventoryId, Long warehouseId, Long productId){
        return inventoryDomainService.queryInventory(inventoryId,warehouseId,productId);
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
