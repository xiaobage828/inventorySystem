package cn.xiaobage.common.aop;

import cn.hutool.core.util.IdUtil;
import cn.xiaobage.common.annotation.RedissonDistributedLock;
import cn.xiaobage.config.redisson.key.KeyType;
import cn.xiaobage.config.redisson.rLock.RLockUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;


@Slf4j
@Component
@Aspect
public class DistributedLockAspect {

    public static final String DEFAULT_KEY = "lock:";

    @Autowired
    ApplicationContext applicationContext;

    private ExpressionParser parser = new SpelExpressionParser();

    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Pointcut("@annotation(cn.xiaobage.common.annotation.RedissonDistributedLock)")
    public void distributedLock() {
    }


    @SneakyThrows
    @Around("distributedLock()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Exception {

        Method method = getMethod(joinPoint);

        RedissonDistributedLock redissonDistributedLock = getDistributedLockAnnotation(method);

        String key = getKey(method, joinPoint.getArgs(), redissonDistributedLock.keyPrefix(),redissonDistributedLock.keyType(),redissonDistributedLock.key());

        RedissonClient redissonClient = getRedissonClient(redissonDistributedLock.redissonClient());

        RLock rLock = RLockUtils.getRLock(redissonClient,redissonDistributedLock.rlockType(),new Object[]{key});

        if(redissonDistributedLock.timeout() == -1L){
            rLock.lock();
        }else{
            rLock.lock(redissonDistributedLock.timeout(), redissonDistributedLock.unit());
        }

        Object result = null;
        try {
            result = joinPoint.proceed();
        }catch (Throwable throwable){
            throw throwable;
        } finally {
            if(null != rLock && rLock.isHeldByCurrentThread())
                rLock.unlock();
        }

        return result;
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        return method;
    }

    private RedissonDistributedLock getDistributedLockAnnotation(Method method) {
        RedissonDistributedLock annotation = method.getAnnotation(RedissonDistributedLock.class);
        return annotation;
    }

    private String getKey(Method method, Object[] args, String keyPrefix, KeyType keyType , String key) {
        String keyText = getKeyText(method,args,keyType,key);
        String fullKey = keyPrefix + keyText;
        return StringUtils.isEmpty(fullKey) ? DEFAULT_KEY : fullKey;
    }

    private String getKeyText(Method method, Object[] args,  KeyType keyType , String key){

        if(keyType == KeyType.NONE){
            return key;
        }

        if(keyType == KeyType.EXPRESSION){
            EvaluationContext context = bindParam(method,args);
            return getValue(context,key);
        }

        if(keyType == KeyType.ASSIGN_ID){

            return IdUtil.getSnowflakeNextIdStr();
        }

        if(keyType == KeyType.ASSIGN_OBJECT_ID){

            return IdUtil.objectId();
        }

        if(keyType == KeyType.ASSIGN_UUID){

            return IdUtil.fastSimpleUUID();
        }

        return "";
    }

    private EvaluationContext bindParam(Method method, Object[] args) {
        //获取方法的参数名
        String[] params = discoverer.getParameterNames(method);
        //将参数名与参数值对应起来
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], args[len]);
        }
        return context;
    }

    private String getValue(EvaluationContext context,String spel){
        Object value = parser.parseExpression(spel).getValue(context);
        return String.valueOf(value);
    }

    private RedissonClient getRedissonClient(String redissonClient){

        return (RedissonClient) applicationContext.getBean(redissonClient);
    }

}