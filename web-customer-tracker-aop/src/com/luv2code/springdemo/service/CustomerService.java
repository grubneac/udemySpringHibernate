package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void save(Customer customer);
	
	public Customer getCustomer(int theid);

	public void deleteCustomer(Customer customer);

	public List<Customer> searchCustomer(String theSearchName); 
}