package com.gcu.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "products")
public class ProductList {
    
    private List<ProductModel> products = new ArrayList<ProductModel>();

    @XmlElement(name="product")
    public List<ProductModel> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

}
