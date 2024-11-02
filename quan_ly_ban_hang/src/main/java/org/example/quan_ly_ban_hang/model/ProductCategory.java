package org.example.quan_ly_ban_hang.model;

public class ProductCategory {
    private int id;
    private String productName;

    public ProductCategory(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }
    public ProductCategory(String productName) {
        this.productName = productName;
    }
    public ProductCategory() {}
    public int getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
