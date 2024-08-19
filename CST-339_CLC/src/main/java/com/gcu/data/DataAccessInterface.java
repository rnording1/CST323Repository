package com.gcu.data;

import java.util.List;

import com.gcu.data.entity.ProductEntity;

public interface DataAccessInterface <T> {
	public List<T> findAll();
	public T findById(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
	ProductEntity findById(long id);
}
