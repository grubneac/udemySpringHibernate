package com.luv2code.springboot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String getHello() {
		return "Hello World! Time on server is "+LocalDateTime.now();
	}
	@GetMapping("/workout")
	public String getWorkOut() {
		return "Run a hard 5k!";
	}
	@GetMapping("/teaminfo")
	public String getCoachName() {
		return "Coach: "+coachName+ ", team name: "+teamName;
	}
}
