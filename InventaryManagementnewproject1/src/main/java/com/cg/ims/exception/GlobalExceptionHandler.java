package com.cg.ims.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	ResponseEntity<String> responseEntity;
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(Exception e){
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;		
	}


	

}
