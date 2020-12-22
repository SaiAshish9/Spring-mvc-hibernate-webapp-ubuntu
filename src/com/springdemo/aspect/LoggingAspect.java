package com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.springdemo.controller.*.*(..))")
	private void forControllerPackage() {

	}

	@Pointcut("execution(* com.springdemo.service.*.*(..))")
	private void forServicePackage() {

	}

	@Pointcut("execution(* com.springdemo.dao.*.*(..))")
	private void forDaoPackage() {

	}	
	
	@Pointcut("forControllerPackage() || forServicePackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		
		logger.info("INFO ==== " + theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object temp:args) {
			logger.info("Arg ===> "+temp);
		}
		
	}

	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint,Object theResult) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		
		logger.info(" @AfterReturning  ===>  "+theMethod);
		
		logger.info(" @AfterReturning result ====> " +  theResult);
		
	}
	
}
