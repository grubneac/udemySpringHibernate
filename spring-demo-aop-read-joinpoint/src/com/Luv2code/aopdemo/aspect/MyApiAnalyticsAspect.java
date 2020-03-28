package com.Luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

	@Before("com.Luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPacageNoGetterSetter()")		
	public void performApiAnalytics() {
		System.out.println("\n======>>>>@Order(2) Performing Api Analytics");
	}
}
