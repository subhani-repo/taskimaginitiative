package com.imageinnovate.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.imageinnovate.demo.response.ExceptionResponse;


@RestControllerAdvice
public class InvalidDataException extends RuntimeException{

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final Exception exception, final HttpServletRequest request) {
		exception.printStackTrace();
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return error;
	}
}
