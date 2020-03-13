package com.luv2code.springdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		//get customer from service
		List<Customer> costomers = customerService.getCustomers();
		
		//add the customer to the model
		model.addAttribute("customers", costomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		customerService.save(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId,Model model ){
		//get customer from our service
		Customer customer = customerService.getCustomer(theId);
		model.addAttribute("customer", customer);
		
		
		return "customer-form";
	}
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("customerId")int theId,Model model ){
		//get customer from our service
		Customer customer = customerService.getCustomer(theId);
		
		//delete customer from our service
		customerService.deleteCustomer(customer);
		
		
		return "redirect:/customer/list";
	}
}
