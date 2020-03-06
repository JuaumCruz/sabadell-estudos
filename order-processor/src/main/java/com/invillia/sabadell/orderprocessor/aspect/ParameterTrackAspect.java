package com.invillia.sabadell.orderprocessor.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ParameterTrackAspect {

    @Pointcut("execution(* com.invillia.sabadell.orderprocessor..*(..))")
    public void anyMethod() {
        // Pointcut definition purpose
    }

    @Before("anyMethod()")
    public void methodCall(JoinPoint joinPoint) throws JsonProcessingException {
        var mapper = new ObjectMapper();

        log.info("Entered in {} with argument[s] = {}", joinPoint.toString(), mapper.writeValueAsString(joinPoint.getArgs()));
    }
}
