package org.example.quan_ly_ban_hang.service.account;

import org.example.quan_ly_ban_hang.model.Account;

import java.util.List;

public interface IAccountService {
    void save(Account account);
    Account findById(int id);
    List<Account> findAll();
    void update(Account account);
    void delete(int id);
    Account findByUsernameAndPassword(String username, String password);
}