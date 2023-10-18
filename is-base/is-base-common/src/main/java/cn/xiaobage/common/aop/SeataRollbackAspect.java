package cn.xiaobage.common.aop;

import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Aspect
@Slf4j
@Component
public class SeataRollbackAspect {

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void seataRollbackAop(){
        throw new UnsupportedOperationException();
    }

    @Before("seataRollbackAop()")
    public void before(JoinPoint joinPoint) throws TransactionException {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();

        if(StringUtils.isNotEmpty(RootContext.getXID())){
            log.info("拦截到需要分布式事务的方法:{},分布式全局事务XID:{}" + method.getName(), RootContext.getXID());
        }

    }

    @AfterThrowing(throwing = "e", pointcut = "seataRollbackAop()")
    public void doRecoveryActions(Throwable e) throws TransactionException {

        if (StringUtils.isNotEmpty(RootContext.getXID())){
            log.info("分布式全局事务XID:{}", RootContext.getXID());
            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
        }

    }

}
