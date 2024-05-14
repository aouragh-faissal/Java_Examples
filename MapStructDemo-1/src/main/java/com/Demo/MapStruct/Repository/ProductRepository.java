package com.Demo.MapStruct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Demo.MapStruct.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
