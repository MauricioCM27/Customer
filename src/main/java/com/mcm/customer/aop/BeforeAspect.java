package com.mcm.customer.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class BeforeAspect {

    @Before("execution(* com.mcm.customer.service.*.*(..))")
    private void logBeforeAspect(final JoinPoint joinPoint) {
        log.info("Class: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Method: {}", joinPoint.getSignature().getName());
        log.info("Args: {}", joinPoint.getArgs());
    }


}
