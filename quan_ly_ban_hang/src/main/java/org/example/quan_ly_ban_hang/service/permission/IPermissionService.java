package org.example.quan_ly_ban_hang.service.permission;

import org.example.quan_ly_ban_hang.model.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll();
    Permission findById(int id);
    void save(Permission permission, boolean isAdmin);
    void update(Permission permission, boolean isAdmin);
    void delete(int id, boolean isAdmin);
}