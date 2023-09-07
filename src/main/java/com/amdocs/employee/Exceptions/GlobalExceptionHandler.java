package com.amdocs.employee.Exceptions;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(bookNotFound.class)
	public ResponseEntity<errordetails>handlebookNotFound(bookNotFound ex){
		errordetails error = new errordetails();
		error.setMessage(ex.getMessage());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setDatetime(LocalDateTime.now());
		
		ResponseEntity<errordetails> res= new ResponseEntity<errordetails>(error,HttpStatus.NOT_FOUND);
		return res;
		
	}
	

}


