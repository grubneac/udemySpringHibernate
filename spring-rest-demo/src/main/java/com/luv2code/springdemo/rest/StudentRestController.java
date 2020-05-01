package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/list")
	public List<Student> getStudents(){
		List<Student> result = new ArrayList<>();
		result.add(new Student("Poornima", "Patel"));
		result.add(new Student("Mario", "Rossi"));
		result.add(new Student("Mary", "Smith"));
		
		return result;
	}

}
