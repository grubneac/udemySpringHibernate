package com.luv2code.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmloyeeController {
	
	//load employee data
	private List<Employee> theEmployee = new ArrayList<>();
	
	@PostConstruct
	private void loadData() {
		theEmployee.add(new Employee(1, "Vasea", "Pecus", "1andre@mail.eu"));
		theEmployee.add(new Employee(1, "gsjaf2", "Andrew2", "2andre@mail.eu"));
		theEmployee.add(new Employee(1, "gsjaf2", "Andrew3", "3andre@mail.eu"));
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		theModel.addAttribute("employees", theEmployee);
		
		return "list-employees";
	}

}
