package com.example.businessmanagement.controller.advice;

import com.example.businessmanagement.service.user.UserEntityNotFoundException;
import com.example.todoapi.model.ResourceNotFoundError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserEntityNotFoundException.class)
	public ResponseEntity<ResourceNotFoundError> handleUserEntityNotFoundException(
			UserEntityNotFoundException e) {
		var error = new ResourceNotFoundError();
		error.setDetail(e.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		var error = BadRequestErrorCreator.from(ex);
		return ResponseEntity.badRequest().body(error);
	}

}