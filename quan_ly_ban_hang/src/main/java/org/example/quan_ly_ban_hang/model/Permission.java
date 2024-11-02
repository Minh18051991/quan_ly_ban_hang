package org.example.quan_ly_ban_hang.model;

public class Permission {
    private int id;
    private int roleId;
    private int accountId;

    public Permission(int id, int roleId, int accountId) {
        this.id = id;
        this.roleId = roleId;
        this.accountId = accountId;
    }
    public Permission(int roleId, int accountId) {
        this.roleId = roleId;
        this.accountId = accountId;
    }
    public Permission() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
