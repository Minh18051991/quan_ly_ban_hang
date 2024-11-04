package org.example.quan_ly_ban_hang.DTO;

import java.util.Date;

public class OrderDTO {
    private int id;
    private String nameCustomer;
    private Date date;
    private Boolean status;
    private Boolean isDelete;

    public OrderDTO(int id, String nameCustomer, Date date, boolean status, boolean isDelete) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.date = date;
        this.status = status;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
