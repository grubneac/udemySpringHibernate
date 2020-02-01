package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SillyController {

	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "silly";
	}
	@RequestMapping("/processForm")
	public String displayProcessForm(@RequestParam("studentName")String name, Model model) {
		//convert the data to all caps
		name = name.toUpperCase();
		//create the message
		String message = "Silly displayProcessForm return "+name;
		
		//add message to model
		model.addAttribute("message", message);		
		return "silly";
	}
	@RequestMapping("/showMainForm")
	public String displayMainMenu() {
		return "main-menu";
	}
}
