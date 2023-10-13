package cn.xiaobage.inventory.domain.inventory.service;

import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.domain.inventory.repository.po.OutboundDeliveryOrderPO;
import org.springframework.stereotype.Service;

@Service
public class OutboundDeliveryOrderFactory {


    public OutboundDeliveryOrderPO createOutboundDeliveryOrderPO(OutboundDeliveryOrder outboundDeliveryOrder){
        OutboundDeliveryOrderPO po = new OutboundDeliveryOrderPO();
        po.setId(outboundDeliveryOrder.getId());
        po.setCreateTime(outboundDeliveryOrder.getCreateTime());
        po.setUnits(outboundDeliveryOrder.getUnits());
        po.setMaker(outboundDeliveryOrder.getMaker());
        po.setQuantity(outboundDeliveryOrder.getQuantity());
        po.setRecordCode(outboundDeliveryOrder.getRecordCode());
        po.setRemark(outboundDeliveryOrder.getRemark());
        po.setInventoryId(outboundDeliveryOrder.getInventoryId());
        po.setTag(outboundDeliveryOrder.getTag());
        po.setTimeOfMaking(outboundDeliveryOrder.getTimeOfMaking());
        po.setTradingTime(outboundDeliveryOrder.getTradingTime());
        po.setTrader(outboundDeliveryOrder.getTrader());
        return po;
    }


    public OutboundDeliveryOrder getOutboundDeliveryOrder(OutboundDeliveryOrderPO po){
        OutboundDeliveryOrder outboundDeliveryOrder = new OutboundDeliveryOrder();
        outboundDeliveryOrder.setId(po.getId());
        outboundDeliveryOrder.setCreateTime(po.getCreateTime());
        outboundDeliveryOrder.setUnits(po.getUnits());
        outboundDeliveryOrder.setMaker(po.getMaker());
        outboundDeliveryOrder.setQuantity(po.getQuantity());
        outboundDeliveryOrder.setRecordCode(po.getRecordCode());
        outboundDeliveryOrder.setRemark(po.getRemark());
        outboundDeliveryOrder.setInventoryId(po.getInventoryId());
        outboundDeliveryOrder.setTag(po.getTag());
        outboundDeliveryOrder.setTimeOfMaking(po.getTimeOfMaking());
        outboundDeliveryOrder.setTradingTime(po.getTradingTime());
        outboundDeliveryOrder.setTrader(po.getTrader());
        return outboundDeliveryOrder;
    }
}
