package com.gcu.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.*;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);
	
}
