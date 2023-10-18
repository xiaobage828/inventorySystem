package cn.xiaobage.common.aop;

import cn.xiaobage.config.api.Response;
import cn.xiaobage.config.exception.IsException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



@Aspect
@Slf4j
@Component
public class FeignClientAspect {

    @Pointcut("within(@org.springframework.cloud.openfeign.FeignClient *)")
    public void feignClientMethodAop(){

    }


    @AfterReturning(value="feignClientMethodAop()",returning = "returnVal")
    public void AfterReturning(Object returnVal){
        if(null != returnVal && returnVal instanceof Response && ((Response) returnVal).getStatus().equals(Response.Status.FAILED)){
            throw new IsException(((Response) returnVal).getMsg());
        }
    }


}
