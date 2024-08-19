package com.gcu.models;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProductModel {
    private Long productID;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 5, max = 100, message = "Description must be between 5 and 100 characters")
    private String description;

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;

    // Getters and setters

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

    // Constructors

    public ProductModel() {}

    public ProductModel(Long productID, String name, String description, BigDecimal price) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
