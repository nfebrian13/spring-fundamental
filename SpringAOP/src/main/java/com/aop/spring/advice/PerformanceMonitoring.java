package com.aop.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoring implements MethodInterceptor {
	
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = methodInvocation.proceed();
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken in ms : " + (endTime - startTime));
		return result;
	}
	
}