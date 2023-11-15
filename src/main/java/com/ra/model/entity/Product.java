package com.ra.model.entity;

public class Product {
    private int productId;
    private String productName, description;

    public Product(int productId, String productName, String description) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
