package com.Luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	@Pointcut("execution( * com.Luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {} 
	
	//create point cut for getter method
	@Pointcut("execution( * com.Luv2code.aopdemo.dao.*.get*(..))")
	public void forGettterMethod() {} 
	
	//create point cut for setter method
	@Pointcut("execution( * com.Luv2code.aopdemo.dao.*.set*(..))")
	public void forSettterMethod() {} 
	
	//create pointcut: include package and exclude setter/getter
	@Pointcut("forDaoPackage() && !(forGettterMethod() || forSettterMethod())")
	public void forDaoPacageNoGetterSetter() {}
	

}
