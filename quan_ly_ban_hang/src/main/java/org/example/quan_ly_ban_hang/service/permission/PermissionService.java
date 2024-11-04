package org.example.quan_ly_ban_hang.service.permission;

import org.example.quan_ly_ban_hang.model.Permission;
import org.example.quan_ly_ban_hang.repository.permission.IPermissionRepository;
import org.example.quan_ly_ban_hang.repository.permission.PermissionRepository;

import java.util.List;

public class PermissionService implements IPermissionService {
    private final IPermissionRepository permissionRepository;

    public PermissionService() {
        this.permissionRepository = new PermissionRepository();
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission findById(int id) {
        return permissionRepository.findById(id);
    }


    @Override
    public void save(Permission permission, boolean isAdmin) {
        if (isAdmin) {
            permissionRepository.save(permission);
        } else {
            throw new SecurityException("Bạn không có quyền thêm quyền.");
        }
    }

    @Override
    public void update(Permission permission, boolean isAdmin) {
        if (isAdmin) {
            permissionRepository.update(permission);
        } else {
            throw new SecurityException("Bạn không có quyền chỉnh sửa quyền.");
        }
    }

    @Override
    public void delete(int id, boolean isAdmin) {
        if (isAdmin) {
            permissionRepository.delete(id);
        } else {
            throw new SecurityException("Bạn không có quyền xóa quyền.");
        }
    }
}