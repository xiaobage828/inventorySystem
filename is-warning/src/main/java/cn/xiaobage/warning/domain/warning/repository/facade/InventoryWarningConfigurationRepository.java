package cn.xiaobage.warning.domain.warning.repository.facade;


import cn.xiaobage.warning.domain.warning.repository.po.InventoryWarningConfigurationPO;

/**
 * <p>
 * 库存预警配置 服务类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
public interface InventoryWarningConfigurationRepository {

    InventoryWarningConfigurationPO query(Long inventoryId);

    int save(InventoryWarningConfigurationPO po);

    int update(InventoryWarningConfigurationPO po);

}
