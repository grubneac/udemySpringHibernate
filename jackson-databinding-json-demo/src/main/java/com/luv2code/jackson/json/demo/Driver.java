package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			//create object mapper
			
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file and convert to Java POJO
			Student theStudent =
					mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			//print the Student
			System.out.println("theStudent= "+theStudent);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
