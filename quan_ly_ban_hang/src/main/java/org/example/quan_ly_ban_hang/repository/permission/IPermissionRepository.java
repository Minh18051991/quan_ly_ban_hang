package org.example.quan_ly_ban_hang.repository.permission;

import org.example.quan_ly_ban_hang.model.Permission;

import java.util.List;

public interface IPermissionRepository {
    void save(Permission permission);
    Permission findById(int id);
    List<Permission> findAll();
    void update(Permission permission);
    void delete(int id);
}