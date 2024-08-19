package com.gcu.repositories;

public interface UsersDataAccessInterface <T> {
	
	public T findByUsername(String username);

}
