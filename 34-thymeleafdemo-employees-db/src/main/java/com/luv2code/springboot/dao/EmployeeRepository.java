package com.luv2code.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//add a method to sort by Last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
