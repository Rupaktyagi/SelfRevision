package com.evaluation.Exception;


import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobelExceptionHandler {

	
	
	@ExceptionHandler(IlligalIInput.class)
	public ResponseEntity<MyErrorDetails> custmExcption(IlligalIInput ie, WebRequest wr)
	{
		
		MyErrorDetails mr=new MyErrorDetails(LocalTime.now(), ie.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(mr,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noException(NoHandlerFoundException noh,WebRequest req){
		
		MyErrorDetails mr=new MyErrorDetails(LocalTime.now(),noh.getMessage(),req.getDescription(false));

	return new ResponseEntity<MyErrorDetails>(mr, HttpStatus.BAD_REQUEST);	
	}
	
}
