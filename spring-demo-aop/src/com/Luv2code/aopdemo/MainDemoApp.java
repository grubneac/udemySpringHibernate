package com.Luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
			AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the buisnes method
			accountDAO.addAccount();
		System.out.println("Run again");
			accountDAO.addAccount();
		
		//close the context
			context.close();
		
	}
}
