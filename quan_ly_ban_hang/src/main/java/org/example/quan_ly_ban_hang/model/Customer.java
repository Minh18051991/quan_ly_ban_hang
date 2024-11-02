package org.example.quan_ly_ban_hang.model;

public class Customer {
private int id;
private String name;
private String address;
private String phone;
private String email;
private boolean isDeleted;

public Customer(String name, String address, String phone, String email, boolean isDeleted) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.isDeleted = isDeleted;
}
public Customer(int id, String name, String address, String phone, String email, boolean isDeleted) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.isDeleted = isDeleted;
}
public Customer(){}

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean delete) {
        isDeleted = delete;
    }
}
