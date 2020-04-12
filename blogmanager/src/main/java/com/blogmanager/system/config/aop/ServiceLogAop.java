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
 * service aop
 */
@Aspect
@Order(5)
@Component
public class ServiceLogAop
{
	private Logger logger = LoggerFactory.getLogger(ServiceLogAop.class);

	@Pointcut("execution(public * com.blogmanager.service.*.*(..))")
	public void serviceLog()
	{
	}

	@Around("serviceLog()")
	public Object execAop(ProceedingJoinPoint pjp) throws Throwable
	{
		logger.debug("start service:" + pjp.getSignature().getName());
		Object o = pjp.proceed();
		logger.debug("end service:" + pjp.getSignature().getName());
		return o;
	}
}
