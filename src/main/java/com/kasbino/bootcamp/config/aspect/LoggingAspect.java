package com.kasbino.bootcamp.config.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {
    private final static Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* com.kasbino.bootcamp..*(..))")
    public void logMethodCallStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String arguments = "Arguments: " + Arrays.stream(args)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        logger.info("method {} called with these arguments {}",
                joinPoint.getSignature().toString(), arguments);
    }

    @After("execution(* com.kasbino.bootcamp..*(..))")
    public void logMethodCallEnd(JoinPoint joinPoint) {
        logger.info("method {} ended", joinPoint.getSignature().toString());
    }

    @AfterThrowing(value = "execution(* com.kasbino.bootcamp..*(..))", throwing = "ex")
    public void logMethodThrowingException(JoinPoint joinPoint, Exception ex) {
        logger.warn("method {} thrown {} with message {}", joinPoint.getSignature().toString(), ex.getClass().getSimpleName(), ex.getMessage());
    }

    @AfterReturning(pointcut = "execution(* com.kasbino.bootcamp..*(..))", returning = "result")
    public void logAfterMethodReturn(JoinPoint joinPoint, Object result) {
        logger.info("method {} returned an object {}", joinPoint.getSignature().toString(),
                result);
    }
}