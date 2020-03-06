package com.invillia.sabadell.orderprocessor.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ResponseTrackAspect {

    @Pointcut("execution(* com.invillia.sabadell.orderprocessor..*(..))")
    public void anyMethod() {
        // Pointcut definition purpose
    }

    @Pointcut("within(com.invillia.sabadell.orderprocessor.client..*)")
    public void anyMethodFromOpenFeignClient() {
        // Pointcut definition purpose
    }

    @AfterReturning(pointcut = "anyMethod()", returning = "response")
    public void methodResponse(JoinPoint joinPoint, Object response) throws JsonProcessingException {
        var mapper = new ObjectMapper();

        log.info("Exited from {} with result = {}", joinPoint.toString(), mapper.writeValueAsString(response));

    }

    @AfterThrowing(pointcut = "anyMethodFromOpenFeignClient()", throwing = "exception")
    public void methodException(JoinPoint joinPoint, Exception exception) {
        log.error("Exception in {} caused for = {}", joinPoint.toString(), exception.toString());
    }
}
