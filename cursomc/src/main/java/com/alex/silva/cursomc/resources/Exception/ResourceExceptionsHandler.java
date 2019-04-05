package com.alex.silva.cursomc.resources.Exception;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javassist.tools.rmi.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionsHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandadError> objectNotFound(ObjectNotFoundException e, HttpServlet request){
     
		StandadError err = new StandadError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
