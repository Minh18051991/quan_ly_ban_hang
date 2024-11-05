package org.example.quan_ly_ban_hang.service.permission;

import org.example.quan_ly_ban_hang.model.Permission;
import org.example.quan_ly_ban_hang.repository.permission.IPermissionRepository;
import org.example.quan_ly_ban_hang.repository.permission.PermissionRepository;

import java.util.List;

public class PermissionService implements IPermissionService {
    private final IPermissionRepository permissionRepository = new PermissionRepository();

    @Override
    public void save(Permission permission) {
        permissionRepository.save(permission);
    }

    @Override
    public Permission findById(int id) {
        return permissionRepository.findById(id);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public void update(Permission permission) {
        permissionRepository.update(permission);
    }

    @Override
    public void delete(int id) {
        permissionRepository.delete(id);
    }
}