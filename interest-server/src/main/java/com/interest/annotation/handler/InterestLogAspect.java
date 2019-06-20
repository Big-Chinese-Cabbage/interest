package com.interest.annotation.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class InterestLogAspect {

    @Pointcut("@annotation(com.interest.annotation.InterestLog)")
    public void interestLogAspect(){}

    @Around("interestLogAspect()")
    public Object printLog(ProceedingJoinPoint point) throws Throwable {
        String className = point.getSignature().getDeclaringTypeName();
        String methodName = point.getSignature().getName();
        log.info("[{}|{}], request param: {}", className, methodName, point.getArgs());
        Object result = point.proceed();
        log.info("[{}|{}], request param: {}, result : {}", className, methodName, point.getArgs(), result);
        return  result;
    }

}
