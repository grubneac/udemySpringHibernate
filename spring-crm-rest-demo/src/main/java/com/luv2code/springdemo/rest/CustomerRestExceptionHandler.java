package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> hadleException(CustomerNotFoundException exc){
		
		// create CustomerErrorResponse
		CustomerErrorResponse theCustomerErrorResponse = 
				new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis()
										);
		
		return new ResponseEntity<>(theCustomerErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	//Add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> hadleException(Exception exc){
		
		// create CustomerErrorResponse
		CustomerErrorResponse theCustomerErrorResponse = 
				new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis()
										);
		
		return new ResponseEntity<>(theCustomerErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
