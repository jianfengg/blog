package com.blogmanager.system.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * dao aop
 */
@Aspect
@Order(5)
@Component
public class DaoLogAop
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(public * com.blogmanager.mapper.*.*(..))")
	public void daoLog()
	{
	}

	@Around("daoLog()")
	public Object execAop(ProceedingJoinPoint pjp) throws Throwable
	{
		logger.debug("start mapper:" + pjp.getSignature().getName());
		Object o = pjp.proceed();
		logger.debug("end mapper:" + pjp.getSignature().getName());
		return o;
	}
}
