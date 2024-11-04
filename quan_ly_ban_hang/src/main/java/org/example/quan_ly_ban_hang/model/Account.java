package org.example.quan_ly_ban_hang.model;

import java.sql.Timestamp;


public class Account {
    private int id;
    private int customerId;
    private String username;
    private String password;
    private Timestamp createdAt;
    private boolean isDeleted;

    public Account(int id, int customerId, String username, String password, Timestamp createdAt, boolean isDeleted) {
        this.id = id;
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }
    public Account(int customerId, String username, String password, Timestamp createdAt, boolean isDeleted) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }
    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

