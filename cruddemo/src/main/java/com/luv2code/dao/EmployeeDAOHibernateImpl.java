package com.luv2code.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {

		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query =  session.createQuery("from Employee", Employee.class);
		 
		 List<Employee> result = query.getResultList();
		 
		return result;
	}


	@Override
	public Employee findById(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Employee theEmployee =  session.get(Employee.class, theId);	
		
		return theEmployee;
	}


	@Override
	public void save(Employee theEmployee) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(theEmployee);
		
	}


	@Override
	public void delete(int theId) {
	
		Session session = entityManager.unwrap(Session.class);
		
//		Employee theEmployee =  session.get(Employee.class, theId);		
//		
//		session.delete(theEmployee);
		
		Query theQuery = session.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}


}
