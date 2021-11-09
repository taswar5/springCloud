package com.orderservice.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class SpringCloudAspect {

	@Around("@annotation(SprCloudLogger)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("source location:::{}"+joinPoint.getSourceLocation().toString());
		log.info("Siganture:::{}"+joinPoint.getSignature());
		Arrays.asList(joinPoint.getArgs()).forEach(k->log.info("Arguments::"+k.toString()));
	    return joinPoint.proceed();
	}
	
}
