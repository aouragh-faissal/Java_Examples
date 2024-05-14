package com.Demo.MapStruct.Validator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductValidatorException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductValidatorException(String message) {
		super(message);

	}



}
