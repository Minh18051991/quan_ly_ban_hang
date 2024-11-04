package org.example.quan_ly_ban_hang.repository.role;

import org.example.quan_ly_ban_hang.model.Role;
import org.example.quan_ly_ban_hang.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository implements IRoleRepository {
    private static final String INSERT_SQL = "INSERT INTO role (name) VALUES (?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM role WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM role";
    private static final String UPDATE_SQL = "UPDATE role SET name = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM role WHERE id = ?";

    @Override
    public void save(Role role) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, role.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role findById(int id) {
        Role role = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role = new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void update(Role role) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, role.getName());
            preparedStatement.setInt(2, role.getId());
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