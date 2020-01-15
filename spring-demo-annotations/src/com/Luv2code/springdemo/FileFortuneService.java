package com.Luv2code.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private List<String> strings = new ArrayList<String>();
	
	@Override
	public String getFortune() {

	   Random rnd =new Random();
	    
	   return strings.get(rnd.nextInt(strings.size()));
		
	}
	@PostConstruct
	public void MyPostConstructMethod() {
	    File file = new File("src/homeWork75.txt");
	    Scanner sc = null;    

	    try {

	       sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            String line = sc.nextLine().trim(); 
	                    //.trim() осуществляет обрезание пробелов
	            strings.add(line) ;  
//	            System.out.println(line); //печать строки в стандартный вывод
	        }

	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    finally {
	        sc.close();
	    }	
	}

}
