package com.luv2code.springboot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String getHello() {
		return "Hello World! Time on server is "+LocalDateTime.now();
	}
	@GetMapping("/workout")
	public String getWorkOut() {
		return "Run a hard 5k!";
	}

}
