package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.models.ProductList;
import com.gcu.models.ProductModel;

@RestController
@RequestMapping("/service")
public class ProductsRestService {
	
	@Autowired
	private ProductsBusinessInterface service;

    @GetMapping(path = "/getjson", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<ProductModel> getProductsAsJson() {
        return service.getProducts();
    }

    @GetMapping(path = "/getxml", produces = { MediaType.APPLICATION_XML_VALUE })
    public ProductList getProductsAsXml() {
    	ProductList list = new ProductList();
        list.setProducts(service.getProducts());
        return list;
    }
    
    @GetMapping(path="/getproduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id){
    	try {
    		ProductModel product = service.getProductByID(id);
    		if(product == null) {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    		else {
    			return new ResponseEntity<>(product, HttpStatus.OK);
    		}
    	}
    	catch(Exception e) {
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
