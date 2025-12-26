package com.jsp.studentadd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceAlreadyException.class)
	public ResponseEntity<String> handleResourceAlreadyExistException(ResourceAlreadyException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<String> handleNoData(NoDataFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	
}

