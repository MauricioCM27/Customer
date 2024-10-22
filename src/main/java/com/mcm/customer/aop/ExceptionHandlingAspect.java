package com.mcm.customer.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExceptionHandlingAspect {

    @AfterThrowing(pointcut = "execution(* com.mcm.customer.service.*.*(..))", throwing = "ex")
    public void handleException(Throwable ex) {

        log.error("Error: {}", ex.getMessage());

    }

}
