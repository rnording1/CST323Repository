package com.gcu.business;

import java.util.List;
import com.gcu.models.ProductModel;

public interface ProductsBusinessInterface {
	public void test();
    public List<ProductModel> getProducts();
    public ProductModel getProductByID(Long id);
    public void init();
    public void destroy();

}
