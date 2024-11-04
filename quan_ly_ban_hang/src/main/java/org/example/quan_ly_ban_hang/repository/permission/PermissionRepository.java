package org.example.quan_ly_ban_hang.repository.permission;

import org.example.quan_ly_ban_hang.model.Permission;
import org.example.quan_ly_ban_hang.repository.BaseRepository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PermissionRepository implements IPermissionRepository {
    private static final String INSERT_SQL = "INSERT INTO permission (role_id, account_id) VALUES (?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM permission WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM permission";
    private static final String UPDATE_SQL = "UPDATE permission SET role_id = ?, account_id = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM permission WHERE id = ?";

    @Override
    public void save(Permission permission) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setInt(1, permission.getRoleId());
            preparedStatement.setInt(2, permission.getAccountId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Permission findById(int id) {
        Permission permission = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                permission = new Permission(
                        resultSet.getInt("id"),
                        resultSet.getInt("role_id"),
                        resultSet.getInt("account_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permission;
    }

    @Override
    public List<Permission> findAll() {
        List<Permission> permissions = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
            while (resultSet.next()) {
                Permission permission = new Permission(
                        resultSet.getInt("id"),
                        resultSet.getInt("role_id"),
                        resultSet.getInt("account_id")
                );
                permissions.add(permission);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permissions;
    }

    @Override
    public void update(Permission permission) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setInt(1, permission.getRoleId());
            preparedStatement.setInt(2, permission.getAccountId());
            preparedStatement.setInt(3, permission.getId());
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
}