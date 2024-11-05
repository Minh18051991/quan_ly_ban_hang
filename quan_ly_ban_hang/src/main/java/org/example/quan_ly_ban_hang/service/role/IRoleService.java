package org.example.quan_ly_ban_hang.service.role;

import org.example.quan_ly_ban_hang.model.Role;

import java.util.List;

public interface IRoleService {
    void save(Role role);
    Role findById(int id);
    List<Role> findAll();
    void update(Role role);
    void delete(int id);
}