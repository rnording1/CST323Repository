package com.gcu.data.entity;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.*;

@Table("Products")
public class ProductEntity {

	@Id
    @Column("productID")
	Long productID;

    @NotEmpty(message = "Name is required")
	@Column("name")
	String name;

    @NotEmpty(message = "Description is required")
	@Column("description")
	String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
	@Column("price")
	BigDecimal price;

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    public ProductEntity(Long productID, String name, String description, BigDecimal price) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
    }
	
	public ProductEntity() {
		
	}
	
}
