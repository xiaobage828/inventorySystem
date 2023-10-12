package cn.xiaobage.warning.infrastructure.client;

import cn.xiaobage.config.api.Response;
import cn.xiaobage.warning.interfaces.dto.DomainEventDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(name = "is-domain-event",path = "/domainEvent")
public interface DomainEventFeignClient {

    @PostMapping("/save")
    @ResponseBody
    Response  save(@RequestBody DomainEventDTO dto);
}
