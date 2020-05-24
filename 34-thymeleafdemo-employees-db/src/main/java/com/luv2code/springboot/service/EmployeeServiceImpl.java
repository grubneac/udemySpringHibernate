package com.luv2code.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.dao.EmployeeRepository;
import com.luv2code.springboot.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> findById = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(findById.isPresent())
			theEmployee= findById.get();
		else
			throw new RuntimeException("Did not find employee id - "+ theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void delete(int theId) {
		employeeRepository.deleteById(theId);

	}

}
