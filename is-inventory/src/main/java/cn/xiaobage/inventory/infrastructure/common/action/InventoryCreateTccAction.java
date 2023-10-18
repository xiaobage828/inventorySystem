package cn.xiaobage.inventory.infrastructure.common.action;

import cn.xiaobage.inventory.domain.inventory.entity.Inventory;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface InventoryCreateTccAction {

    @TwoPhaseBusinessAction(name = "inventoryCreateTccAction", commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepareInventoryCreate(BusinessActionContext businessActionContext,
                                    @BusinessActionContextParameter(paramName = "inventoryId") Long inventoryId, Inventory inventory);

    /**
     * 二阶段提交
     * @param businessActionContext
     * @return
     */
    boolean commit(BusinessActionContext businessActionContext);

    /**
     * 二阶段回滚
     * @param businessActionContext
     * @return
     */
    boolean rollback(BusinessActionContext businessActionContext);
}
