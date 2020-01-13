package com.Luv2code.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String []stringsArray; 
	
	@Override
	public String getFortune() {
	    File file = new File("src/homeWork75.txt");
	    List<String> strings = new ArrayList<String>();
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

	   Random rnd =new Random();
	    
	   return strings.get(rnd.nextInt(strings.size()));
		
	}

}
