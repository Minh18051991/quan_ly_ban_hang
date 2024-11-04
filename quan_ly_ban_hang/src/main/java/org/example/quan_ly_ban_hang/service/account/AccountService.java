package org.example.quan_ly_ban_hang.service.account;

import org.example.quan_ly_ban_hang.model.Account;

import org.example.quan_ly_ban_hang.repository.account.AccountRepository;
import org.example.quan_ly_ban_hang.repository.account.IAccountRepository;

import java.util.List;

public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository = new AccountRepository();

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void update(Account account) {
        accountRepository.update(account);
    }

    @Override
    public void delete(int id) {
        accountRepository.delete(id);
    }
    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }
}
