package com.interest.annotation.handler;

import com.interest.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class InterestLogAspect {

    /**
     * redis存储key值
     */
    public final static String INTEREST_LOG_KEY = "interest-exception";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(com.interest.annotation.InterestLog)")
    public void interestLogAspect() {
    }

    @Around("interestLogAspect()")
    public Object printLog(ProceedingJoinPoint point) throws Throwable {
        String className = point.getSignature().getDeclaringTypeName();
        String methodName = point.getSignature().getName();
        log.info("[{}|{}], request param: {}", className, methodName, point.getArgs());
        Object result = point.proceed();
        log.info("[{}|{}], request param: {}, result : {}", className, methodName, point.getArgs(), result);
        return result;
    }

    @AfterThrowing(throwing = "ex", pointcut = "interestLogAspect()")
    public void exceptionHandle(JoinPoint point, Exception ex) {
        String className = point.getSignature().getDeclaringTypeName();
        String methodName = point.getSignature().getName();

        InterestException interestException = new InterestException();
        interestException.setCreateTime(DateUtil.currentLocalDataTime());
        interestException.setLocation("[" + className + "|" + methodName + "], request param: " + Arrays.toString(point.getArgs()));
        interestException.setMessage(ex.getClass().getName() + ": " + ex.getMessage());
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();

        listOperations.leftPush(INTEREST_LOG_KEY, interestException);
    }
}
