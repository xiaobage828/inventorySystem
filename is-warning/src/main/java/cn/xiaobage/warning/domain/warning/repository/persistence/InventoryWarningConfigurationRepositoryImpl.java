package cn.xiaobage.warning.domain.warning.repository.persistence;

import cn.xiaobage.warning.domain.warning.repository.facade.InventoryWarningConfigurationRepository;
import cn.xiaobage.warning.domain.warning.repository.mapper.InventoryWarningConfigurationMapper;
import cn.xiaobage.warning.domain.warning.repository.po.InventoryWarningConfigurationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存预警配置 服务实现类
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Service
public class InventoryWarningConfigurationRepositoryImpl implements InventoryWarningConfigurationRepository {

    @Autowired
    InventoryWarningConfigurationMapper inventoryWarningConfigurationMapper;


    @Override
    public InventoryWarningConfigurationPO query(Long inventoryId) {
        return inventoryWarningConfigurationMapper.selectById(inventoryId);
    }

    @Override
    public int save(InventoryWarningConfigurationPO po) {
        return inventoryWarningConfigurationMapper.insert(po);
    }

    @Override
    public int update(InventoryWarningConfigurationPO po) {
        return inventoryWarningConfigurationMapper.updateById(po);
    }
}
