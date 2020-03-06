package com.invillia.sabadell.orderprocessor.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ExecutionTimeTrackerAspect {

    @Around("@annotation(ExecutionTimeTracker)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {

        var stopwatch = new StopWatch();
        stopwatch.start();
        var response = joinPoint.proceed();
        stopwatch.stop();

        log.info("Processed {} in {} ms", joinPoint.toString(), stopwatch.getTotalTimeMillis());

        return response;
    }
}
