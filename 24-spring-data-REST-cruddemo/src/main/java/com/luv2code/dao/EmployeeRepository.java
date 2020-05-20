package com.luv2code.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
