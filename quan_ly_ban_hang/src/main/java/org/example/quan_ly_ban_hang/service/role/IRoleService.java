package org.example.quan_ly_ban_hang.service.role;

import org.example.quan_ly_ban_hang.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findById(int id);
    Role findByName(String name); // Thêm phương thức này
    void save(Role role);
    void update(Role role);
    void delete(int id);
}