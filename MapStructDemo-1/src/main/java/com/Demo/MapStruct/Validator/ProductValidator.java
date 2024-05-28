package com.Demo.MapStruct.Validator;

import org.springframework.stereotype.Component;

@Component
public class ProductValidator {
	
	public int validate(int id) throws ProductValidatorException{
		if (id == -1) {
			throw new ProductValidatorException("invalid id value");
		}
		return id;
	}

}
