package cn.xiaobage.inventory.interfaces.assembler;


import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.interfaces.dto.OutboundDeliveryOrderDTO;

public class OutboundDeliveryOrderAssembler{


    public static OutboundDeliveryOrder toDo(OutboundDeliveryOrderDTO dto){
        OutboundDeliveryOrder outboundDeliveryOrder = new OutboundDeliveryOrder();
        outboundDeliveryOrder.setId(dto.getId());
        outboundDeliveryOrder.setCreateTime(dto.getCreateTime());
        outboundDeliveryOrder.setUnits(dto.getUnits());
        outboundDeliveryOrder.setMaker(dto.getMaker());
        outboundDeliveryOrder.setQuantity(dto.getQuantity());
        outboundDeliveryOrder.setRecordCode(dto.getRecordCode());
        outboundDeliveryOrder.setRemark(dto.getRemark());
        outboundDeliveryOrder.setInventoryId(dto.getInventoryId());
        outboundDeliveryOrder.setTag(dto.getTag());
        outboundDeliveryOrder.setTimeOfMaking(dto.getTimeOfMaking());
        outboundDeliveryOrder.setTradingTime(dto.getTradingTime());
        outboundDeliveryOrder.setTrader(dto.getTrader());
        return outboundDeliveryOrder;
    }
}
