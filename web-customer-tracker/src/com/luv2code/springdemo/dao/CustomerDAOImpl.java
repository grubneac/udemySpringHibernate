package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	//need inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create a query
		//execute query and get result list
		List<Customer> list = session.createQuery("from Customer",Customer.class).getResultList();
		
		//return result
		return list;
	}

}
