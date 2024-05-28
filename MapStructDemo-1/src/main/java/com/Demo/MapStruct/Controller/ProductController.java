package com.Demo.MapStruct.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.MapStruct.Mapper.ProductMapper;
import com.Demo.MapStruct.Repository.ProductRepository;
import com.Demo.MapStruct.dto.ProductDto;
import com.Demo.MapStruct.model.Product;

@RestController
public class ProductController {
	
	@Autowired
	private ProductMapper productmapper;
	
	
	@Autowired
	private ProductRepository productrepository;
	
	@PostMapping("/products")
	public ResponseEntity<Product> save(@RequestBody ProductDto productdto){
		
		return new ResponseEntity<>(productrepository.
				save(productmapper.DtotoToModel(productdto)) , HttpStatus.CREATED );
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> findAll(){
		
		return new ResponseEntity<>(productmapper.ModelsToDtos(productrepository.findAll()) , HttpStatus.OK);
	}
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto> findById(@PathVariable(value="id") Integer id){
		
		return new ResponseEntity<>(productmapper.ModelToDto(productrepository.findById(id).get()) , HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(value="id") Integer id){
		
		ProductDto productDto = productmapper.ModelToDto(productrepository.findById(id).get());
		
		productrepository.deleteById(productDto.getId());
		
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	}

}
