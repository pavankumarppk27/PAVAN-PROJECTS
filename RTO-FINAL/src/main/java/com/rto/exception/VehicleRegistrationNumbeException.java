package com.rto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VehicleRegistrationNumbeException extends RuntimeException {

	

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	
	@ExceptionHandler(VehicleRegistrationNumbeException.class)
	public ResponseEntity<String> hadleException(){
		
		return new ResponseEntity<String>("Vehicle Registration Number is Not Found",HttpStatus.BAD_REQUEST);	
	}
	
	
	
}
