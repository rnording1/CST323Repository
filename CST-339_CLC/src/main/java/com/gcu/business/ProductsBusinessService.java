package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ProductsDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.models.ProductModel;

@Service
public class ProductsBusinessService implements ProductsBusinessInterface {

	@Autowired
	private ProductsDataService service;
	
	@Override
	public void test() {

		System.out.println("Hello from the ProductsBusinessService");

	}

	@Override
	public List<ProductModel> getProducts() {
    	
    	List<ProductEntity> ProductsEntity = service.findAll();
    	
    	List<ProductModel> ProductsDomain = new ArrayList<ProductModel>();
    	for(ProductEntity entity : ProductsEntity) {
    		ProductsDomain.add(new ProductModel(entity.getProductID(), entity.getName(), entity.getDescription(), entity.getPrice()));
    	}
    	
    	return ProductsDomain;
	}

	@Override
	public ProductModel getProductByID(Long id) {

		ProductEntity productEntity = service.findById(id);
		
		return new ProductModel(productEntity.getProductID(), productEntity.getName(), productEntity.getDescription(), productEntity.getPrice());
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
