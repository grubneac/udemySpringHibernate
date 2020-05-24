package com.luv2code.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.entity.Employee;
import com.luv2code.springboot.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmloyeeController {
	
	
	@Autowired
	private EmployeeService theEmployeeService;

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployee= theEmployeeService.findAll();
		theModel.addAttribute("employees", theEmployee);
		
		return "list-employees";
	}

}
