package cn.xiaobage.domainEvent.interfaces.facade;


import cn.xiaobage.common.api.Response;
import cn.xiaobage.domainEvent.application.service.DomainEventApplicationService;
import cn.xiaobage.domainEvent.interfaces.assembler.DomainEventAssembler;
import cn.xiaobage.domainEvent.interfaces.dto.DomainEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 领域事件 前端控制器
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@RestController
@RequestMapping("/domainEvent")
public class DomainEventApi {

    @Autowired
    DomainEventApplicationService domainEventApplicationService;

    @PostMapping("/save")
    public Response save(@RequestBody DomainEventDTO dto){
        return Response.ok(domainEventApplicationService.save(DomainEventAssembler.toDO(dto)));
    }
}

