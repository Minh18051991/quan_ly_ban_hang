package org.example.quan_ly_ban_hang.service.account;

import org.example.quan_ly_ban_hang.model.Account;
import org.example.quan_ly_ban_hang.repository.account.IAccountRepository;
import org.example.quan_ly_ban_hang.repository.account.AccountRepository;

import java.util.List;

public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    @Override
    public List<Account> findAll() {
        // Chỉ Admin mới có quyền xem tất cả tài khoản
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int id, boolean isAdmin, int userId) {
        if (isAdmin || id == userId) {
            return accountRepository.findById(id);
        }
        throw new SecurityException("Bạn không có quyền xem thông tin tài khoản này.");
    }

    @Override
    public void save(Account account) {
        // Chỉ Admin mới có thể thêm tài khoản cho người dùng
        accountRepository.save(account);
    }

    @Override
    public void update(Account account, int userId) {
        // Kiểm tra xem người dùng có quyền chỉnh sửa không
        if (account.getIdKhachHang() == userId) { // Sử dụng toán tử == để so sánh
            accountRepository.update(account);
        } else {
            throw new SecurityException("Bạn không có quyền chỉnh sửa tài khoản này.");
        }
    }

    @Override
    public void delete(int id, boolean isAdmin) {
        // Chỉ Admin mới có quyền xóa tài khoản
        if (isAdmin) {
            accountRepository.delete(id);
        } else {
            throw new SecurityException("Bạn không có quyền xóa tài khoản.");
        }
    }

    @Override
    public Account login(String username, String password) {
        // Thực hiện kiểm tra thông tin đăng nhập
        Account account = accountRepository.findByUsername(username);
        if (account != null && account.getPassword().equals(password)) {
            return account; // Trả về tài khoản nếu thông tin đúng
        }
        return null; // Trả về null nếu không tìm thấy
    }
}