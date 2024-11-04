package org.example.quan_ly_ban_hang.repository.account;

import org.example.quan_ly_ban_hang.model.Account;
import org.example.quan_ly_ban_hang.repository.BaseRepository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    private static final String INSERT_SQL = "INSERT INTO account (customer_id, username, password, created_at, is_deleted) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM account WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM account";
    private static final String UPDATE_SQL = "UPDATE account SET customer_id = ?, username = ?, password = ?, created_at = ?, is_deleted = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM account WHERE id = ?";

    @Override
    public void save(Account account) {
        // Kiểm tra xem account có null không
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setInt(1, account.getCustomerId());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setTimestamp(4, account.getCreatedAt());
            preparedStatement.setBoolean(5, account.isDeleted());
            int rowsAffected = preparedStatement.executeUpdate();

            // Kiểm tra số hàng bị ảnh hưởng
            if (rowsAffected == 0) {
                throw new SQLException("Failed to insert account, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findById(int id) {
        Account account = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = new Account(
                        resultSet.getInt("id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getBoolean("is_deleted")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getInt("id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getBoolean("is_deleted")
                );
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public void update(Account account) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setInt(1, account.getCustomerId());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setTimestamp(4, account.getCreatedAt());
            preparedStatement.setBoolean(5, account.isDeleted());
            preparedStatement.setInt(6, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Account findByUsernameAndPassword(String username, String password) {
        Account account = null;
        String sql = "SELECT * FROM account WHERE username = ? AND password = ?"; // Cần kiểm tra cả mật khẩu
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password); // Cần thêm mật khẩu vào điều kiện
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = new Account(
                        resultSet.getInt("id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getBoolean("is_deleted")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}