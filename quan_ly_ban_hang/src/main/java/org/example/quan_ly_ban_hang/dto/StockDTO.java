package org.example.quan_ly_ban_hang.dto;

import java.sql.Timestamp;

public class StockDTO {
    private int id;
    private int productID;
    private String productName;
    private int quantity;
    private Timestamp createAT;
    private boolean isDetele;

    public StockDTO() {
    }

    public StockDTO(int productID, String productName, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
    }

    public StockDTO(int productID, String productName, int quantity, boolean isDetele) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.isDetele = isDetele;
    }

    public StockDTO(String productName, int quantity, boolean isDetele) {
        this.productName = productName;
        this.quantity = quantity;
        this.isDetele = isDetele;
    }

    public StockDTO(int id, int productID, String productName, int quantity, Timestamp createAT, boolean isDetele) {
        this.id = id;
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.createAT = createAT;
        this.isDetele = isDetele;
    }

    public StockDTO(int productID, int quantity, Timestamp createAT) {
        this.productID = productID;
        this.quantity = quantity;
        this.createAT = createAT;
    }

    public StockDTO(String productName, boolean isDetele, int quantity, int productID) {
        this.productName = productName;
        this.isDetele = isDetele;
        this.quantity = quantity;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getCreateAT() {
        return createAT;
    }

    public void setCreateAT(Timestamp createAT) {
        this.createAT = createAT;
    }

    public boolean isDetele() {
        return isDetele;
    }

    public void setDetele(boolean detele) {
        isDetele = detele;
    }
}

