package com.Luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.Luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT");
	}
}
