package org.example.quan_ly_ban_hang.model;

import java.sql.Timestamp;

public class Product {
    private int id;
    private int productCategoryId;
    private String productName;
    private String description;
    private double price;
    private String image;
    private Timestamp createdAt;
    private boolean isDeleted;

    public Product(int id, int productCategoryId, String productName, String description, double price, String image, Timestamp createdAt, boolean isDeleted) {
        this.id = id;
        this.productCategoryId = productCategoryId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    public Product(int productCategoryId, String productName, String description, double price, String image, Timestamp createdAt, boolean isDeleted) {
        this.productCategoryId = productCategoryId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
