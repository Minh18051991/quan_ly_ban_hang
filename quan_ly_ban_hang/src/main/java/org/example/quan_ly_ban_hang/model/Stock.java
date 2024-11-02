package org.example.quan_ly_ban_hang.model;


import java.sql.Timestamp;

public class Stock {
    private int id;
    private int productId;
    private int quantity;
    private Timestamp createdAt;
    private boolean isDeleted;

    public Stock(int id, int productId, int quantity, Timestamp createdAt, boolean isDeleted) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    public Stock(int productId, int quantity, Timestamp createdAt, boolean isDeleted) {
        this.productId = productId;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    public Stock() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
