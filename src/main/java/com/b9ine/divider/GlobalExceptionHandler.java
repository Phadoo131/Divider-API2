package com.b9ine.divider;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.b9ine.divider.exception.DataAlreadyAddedException;
import com.b9ine.divider.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.b9ine.divider.exception.CustomerAlreadyAddedException;
import com.b9ine.divider.exception.CustomerNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {	
	@ExceptionHandler(CustomerAlreadyAddedException.class)
	public void springHandleDuplicated(HttpServletResponse response) throws IOException{
		response.sendError(HttpStatus.NOT_ACCEPTABLE.value());
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public void springHandleNotFound(HttpServletResponse response) throws IOException{
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler(DataNotFoundException.class)
	public void springHandleNotFoundAll(HttpServletResponse response) throws IOException{
		response.sendError(HttpStatus.NOT_FOUND.value());

	}

	@ExceptionHandler(DataAlreadyAddedException.class)
	public void springHandleDupAll(HttpServletResponse response) throws IOException{
		response.sendError(HttpStatus.NOT_ACCEPTABLE.value());

	}
}