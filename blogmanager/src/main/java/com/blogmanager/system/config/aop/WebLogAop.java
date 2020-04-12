package com.blogmanager.system.config.aop;

import com.blogmanager.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * controller aop
 */
@Aspect
@Order(5)
@Component
public class WebLogAop {
	ThreadLocal<Long> startTime = new ThreadLocal<>();
	private Logger logger = LoggerFactory.getLogger(ServiceLogAop.class);

	@Pointcut("execution(public * com.blogmanager.controller..*.*(..))")
	public void webLog(){

	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws JsonProcessingException
	{
		startTime.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature()
				.getName());
		if (joinPoint.getArgs().length == 2){
			// 常规post json加上校验写法
			logger.info("ARGS : " + JsonUtil.toJson(joinPoint.getArgs()[0]));
		}
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable{
		// 处理完请求，返回内容
		logger.info("RESPONSE : " + ret);
		logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	}
}
