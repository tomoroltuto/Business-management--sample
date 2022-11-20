package com.example.businessmanagement.controller.advice;

import com.example.todoapi.model.BatRequestError;
import com.example.todoapi.model.InvalidParam;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class BadRequestErrorCreator {

	public static BatRequestError from(MethodArgumentNotValidException ex) {
		var invalidParamList = createInvalidParamList(
				ex.getFieldErrors()
						.stream()
						.map(BadRequestErrorCreator::createInvalidParam));
		var error = new BatRequestError();
		error.setInvalidParams(invalidParamList);
		return error;
	}
	private static InvalidParam createInvalidParam(FieldError fieldError) {
		var invalidParam = new InvalidParam();
		invalidParam.setName(fieldError.getField());
		invalidParam.setReason(fieldError.getDefaultMessage());
		return invalidParam;
	}

	private static List<InvalidParam> createInvalidParamList(Stream<InvalidParam> ex) {
		return ex.collect(Collectors.toList());
	}
}