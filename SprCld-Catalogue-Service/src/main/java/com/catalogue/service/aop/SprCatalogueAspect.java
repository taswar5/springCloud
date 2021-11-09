package com.catalogue.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class SprCatalogueAspect {

	@Before(value = "@annotation(SprCatalogeLogger)")
	public void logBeforeExcecution(JoinPoint jointPoint) {
		log.info("Before Each method logger::::" + jointPoint.getSignature());
	}

}
