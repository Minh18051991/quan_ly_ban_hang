package org.example.quan_ly_ban_hang.service.role;

import org.example.quan_ly_ban_hang.model.Role;
import org.example.quan_ly_ban_hang.repository.role.IRoleRepository;
import org.example.quan_ly_ban_hang.repository.role.RoleRepository;

import java.util.List;

public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;

    public RoleService() {
        this.roleRepository = new RoleRepository();
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name); // Đảm bảo rằng phương thức này cũng có trong repository
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void update(Role role) {
        roleRepository.update(role);
    }

    @Override
    public void delete(int id) {
        roleRepository.delete(id);
    }
}