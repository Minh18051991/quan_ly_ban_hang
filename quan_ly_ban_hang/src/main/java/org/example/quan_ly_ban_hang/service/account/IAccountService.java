package org.example.quan_ly_ban_hang.service.account;

import org.example.quan_ly_ban_hang.model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findById(int id, boolean isAdmin, int userId);
    void save(Account account);
    void update(Account account, int userId);
    void delete(int id, boolean isAdmin);
    Account login(String username, String password); // Thêm phương thức login
}