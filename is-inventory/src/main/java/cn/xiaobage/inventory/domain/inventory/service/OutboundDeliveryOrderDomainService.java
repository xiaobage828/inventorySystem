package cn.xiaobage.inventory.domain.inventory.service;

import cn.xiaobage.inventory.domain.inventory.entity.OutboundDeliveryOrder;
import cn.xiaobage.inventory.domain.inventory.repository.facade.OutboundDeliveryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutboundDeliveryOrderDomainService {

    @Autowired
    OutboundDeliveryOrderFactory outboundDeliveryOrderFactory;

    @Autowired
    OutboundDeliveryOrderRepository outboundDeliveryOrderRepositoryImpl;

    public int createOutboundDeliveryOrder(OutboundDeliveryOrder outboundDeliveryOrder){
        outboundDeliveryOrder.create();
        return outboundDeliveryOrderRepositoryImpl.insert(outboundDeliveryOrderFactory.createOutboundDeliveryOrderPO(outboundDeliveryOrder));
    }
}
