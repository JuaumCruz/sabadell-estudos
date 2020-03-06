package com.invillia.sabadell.orderproxy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ExecutionTimeTrackerAspect {

    @Pointcut("execution(* com.invillia.sabadell..*(..))")
    public void anyMethod() {
        // Pointcut definition purpose
    }

    @Around("anyMethod()")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {

        var stopwatch = new StopWatch(joinPoint.getSignature().getDeclaringTypeName());
        stopwatch.start(joinPoint.getSignature().getName());
        var response = joinPoint.proceed();
        stopwatch.stop();

        log.info(stopwatch.toString());

        return response;
    }
}
