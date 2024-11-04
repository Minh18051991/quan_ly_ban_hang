package org.example.quan_ly_ban_hang.repository.role;

import org.example.quan_ly_ban_hang.model.Role;

import java.util.List;

public interface IRoleRepository {
    void save(Role role);
    Role findById(int id);
    List<Role> findAll();
    void update(Role role);
    void delete(int id);
}