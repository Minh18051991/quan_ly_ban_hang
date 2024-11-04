package org.example.quan_ly_ban_hang.repository.customer;

import org.example.quan_ly_ban_hang.DTO.CustomerPurchaseDTO;
import org.example.quan_ly_ban_hang.model.Customer;
import org.example.quan_ly_ban_hang.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.quan_ly_ban_hang.repository.BaseRepository.getConnectDB;

public class CustomerRepository implements ICustomerRepository {
    private static final String INSERT_SQL = "INSERT INTO customer (name, address, phone, email, is_deleted) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM customer WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM customer";
    private static final String UPDATE_SQL = "UPDATE customer SET name = ?, address = ?, phone = ?, email = ?, is_deleted = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM customer WHERE id = ?";

    @Override
    public int save(Customer customer) {
        int generatedId = -1; // Biến để lưu id được tạo
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setBoolean(5, customer.isDeleted());
            preparedStatement.executeUpdate();

            // Lấy id được tạo ra
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1); // Lấy id từ ResultSet
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedId; // Trả về id của khách hàng
    }
    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("is_deleted")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("is_deleted")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void update(Customer customer) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setBoolean(5, customer.isDeleted());
            preparedStatement.setInt(6, customer.getId());
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