package cn.xiaobage.warning.application.service;

import cn.xiaobage.common.annotation.RedissonDistributedLock;
import cn.xiaobage.config.redisson.rLock.RLockType;
import cn.xiaobage.warning.domain.warning.entity.InventoryWarningConfiguration;
import cn.xiaobage.warning.domain.warning.service.InventoryWarningConfigurationDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryWarningConfigurationApplicationService {

    @Autowired
    InventoryWarningConfigurationDomainService inventoryWarningConfigurationDomainService;

    public InventoryWarningConfiguration query(Long inventoryId){
        return inventoryWarningConfigurationDomainService.query(inventoryId);
    }

    public int save(InventoryWarningConfiguration inventoryWarningConfiguration){
        return inventoryWarningConfigurationDomainService.save(inventoryWarningConfiguration);
    }

    @RedissonDistributedLock(rlockType = RLockType.REDISSON_WRITE_LOCK, keyPrefix = "lock:inventory_warning_configuration:",key = "#inventoryWarningConfiguration.id")
    public int update(InventoryWarningConfiguration inventoryWarningConfiguration){
        return inventoryWarningConfigurationDomainService.update(inventoryWarningConfiguration);
    }
}
