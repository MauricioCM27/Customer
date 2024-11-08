package com.mcm.customer.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AfterAspect {

    @After("execution(* com.mcm.customer.service.*.*(..))")
    private void logAfterAspect(final JoinPoint joinPoint) throws Throwable {
        log.info("Class: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Method: {}", joinPoint.getSignature().getName());
        log.info("Args: {}", joinPoint.getArgs());

        //final Object object = joinPoint.proceed();

        //log.info("Response: {}", object);

    }

    @Around("execution(* com.mcm.customer.service.*.*(..))")
    private Object logAroundAspect(final ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Class: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Method: {}", joinPoint.getSignature().getName());
        log.info("Args: {}", joinPoint.getArgs());

        final Object object = joinPoint.proceed();

        log.info("Response: {}", object);

        return object;

    }

}
