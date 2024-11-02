package org.example.quan_ly_ban_hang.model;

import java.sql.Timestamp;

public class Order {
    private int id;
    private int accountId;
    private Timestamp orderDate;
    private boolean status;
    private boolean isDeleted;

    public Order(int id, int accountId, Timestamp orderDate, boolean status, boolean isDeleted) {
        this.id = id;
        this.accountId = accountId;
        this.orderDate = orderDate;
        this.status = status;
        this.isDeleted = isDeleted;
    }
    public Order(int accountId, Timestamp orderDate, boolean status, boolean isDeleted) {
        this.accountId = accountId;
        this.orderDate = orderDate;
        this.status = status;
        this.isDeleted = isDeleted;
    }
    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}