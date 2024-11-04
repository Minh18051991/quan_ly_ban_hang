package org.example.quan_ly_ban_hang.repository;

import org.example.quan_ly_ban_hang.DTO.CustomerPurchaseDTO;
import org.example.quan_ly_ban_hang.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.quan_ly_ban_hang.repository.BaseRepository.getConnectDB;

public class CustomerRepository implements ICustomerRepository {

    @Override
    public List<Customer> GetAllCustomers(int page, int pageSize) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer WHERE is_deleted = false LIMIT ? OFFSET ?";

        try (Connection connection = getConnectDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pageSize);
            statement.setInt(2, (page - 1) * pageSize);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setDeleted(resultSet.getBoolean("is_deleted"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }



    @Override
    public List<Customer> FindCustomerByName(String name) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer WHERE name LIKE ? AND is_deleted = false";

        try (Connection connection = getConnectDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setDeleted(resultSet.getBoolean("is_deleted"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public int getTotalCustomers() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM customer WHERE is_deleted = false";

        try (Connection connection = getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public boolean deleteCustomer(int id) {
        String sql = "UPDATE customer SET is_deleted = true WHERE id = ?";
        try (Connection connection = getConnectDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<CustomerPurchaseDTO> GetTopCustomersByProductCount() {
        List<CustomerPurchaseDTO> topCustomers = new ArrayList<>();
        String sql = "SELECT c.id AS customer_id, c.name AS customer_name, SUM(od.quantity) AS product_count " +
                "FROM customer c " +
                "JOIN account a ON c.id = a.customer_id " +
                "JOIN order_bill ob ON a.id = ob.account_id " +
                "JOIN order_details od ON ob.id = od.order_id " +
                "WHERE ob.is_deleted = false " +
                "GROUP BY c.id " +
                "ORDER BY product_count DESC;";

        try (Connection connection = getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                CustomerPurchaseDTO dto = new CustomerPurchaseDTO(
                        resultSet.getInt("customer_id"),
                        resultSet.getString("customer_name"),
                        resultSet.getInt("product_count")
                );
                topCustomers.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topCustomers;
    }
}
