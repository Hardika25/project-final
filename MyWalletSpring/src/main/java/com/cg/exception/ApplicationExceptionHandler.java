package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.exception.Exception;

@ControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler({Exception.class})
	public ResponseEntity<String> handleError(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
