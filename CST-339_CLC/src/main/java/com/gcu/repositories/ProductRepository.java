package com.gcu.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.*;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
	
}
