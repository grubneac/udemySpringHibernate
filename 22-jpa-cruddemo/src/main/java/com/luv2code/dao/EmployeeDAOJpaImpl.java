package com.luv2code.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Employee> findAll() {
		Query theQuery =entityManager.createQuery("from Employee");
		List<Employee> result = theQuery.getResultList();
		return result;
	}

	@Override
	public Employee findById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void delete(int theId) {
		Query theQuery= entityManager.createQuery("delete from Employee where id= :employeeId");
		
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}
