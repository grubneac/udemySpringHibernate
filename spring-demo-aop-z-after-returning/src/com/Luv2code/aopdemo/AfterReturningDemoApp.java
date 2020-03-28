package com.Luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
			AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
	
		// call method to find the accounts
			List<Account> theListAccount = accountDAO.fiendAccounts();
		
		//display theListAccount
			System.out.println("\n\nMain program: AfterReturningDemoApp");
			System.out.println("-----------------------------------------");
			System.out.println(theListAccount);
			System.out.println("-----------------------------------------\n");
		
		//close the context
			context.close();
		
	}
}
