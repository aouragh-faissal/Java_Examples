package com.Demo.MapStruct.Mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Demo.MapStruct.Validator.ProductValidator;
import com.Demo.MapStruct.Validator.ProductValidatorException;
import com.Demo.MapStruct.dto.ProductDto;
import com.Demo.MapStruct.model.Product;

@Mapper(uses = {ProductValidator.class} , componentModel = "spring", imports = UUID.class)
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	//@Mapping(source="product.desc" , target="description", defaultValue="description")
	//@Mapping(target="itemId" , expression= "java(UUID.randomUUID().toString())")
	//@Mapping(source="items" , target="itemsList")
	ProductDto ModelToDto(Product product) throws ProductValidatorException;
	
	List<ProductDto> ModelsToDtos(List<Product> products) throws ProductValidatorException;
	
	@InheritInverseConfiguration
	Product DtotoToModel(ProductDto productDto) throws ProductValidatorException;
	

}
