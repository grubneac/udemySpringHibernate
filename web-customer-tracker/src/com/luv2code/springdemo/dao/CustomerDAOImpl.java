package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create a query
		//execute query and get result list
		//sort by LastName
		List<Customer> list = session.createQuery("from Customer order by lastName",
				Customer.class).getResultList();
		
		//return result
		return list;
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
		
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = null;
		theSearchName = theSearchName.toLowerCase();
		System.out.println("theSearchName="+theSearchName);
		if (theSearchName != null && theSearchName.trim().length()>0) {
			theQuery= session.createQuery("from Customer where lower(firstName) like :theSearchName"
														+ " or lower(lastName) like :theSearchName",Customer.class);
			theQuery.setParameter("theSearchName","%"+ theSearchName + "%");
		}else {
			theQuery =session.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> theCustomers = theQuery.getResultList();
		return theCustomers;
	}

}
