package com.sdgt.zuul.repository;

import com.sdgt.zuul.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
	
	@Override
    void delete(Product deleted);
}
