package org.example.quan_ly_ban_hang.repository.product;



import org.example.quan_ly_ban_hang.dto.ProductDTO;
import org.example.quan_ly_ban_hang.model.Product;
import org.example.quan_ly_ban_hang.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> finAll() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product WHERE is_deleted = false";

        try (Connection connection = BaseRepository.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getInt("product_category_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("image"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getBoolean("is_deleted")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        String query = "SELECT * FROM product WHERE id = ? AND is_deleted = false";
        Product product = null;

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getInt("product_category_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("image"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getBoolean("is_deleted")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void save(Product product) {
        String query = "INSERT INTO product (product_category_id, product_name, description, price, image, is_deleted) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, product.getProductCategoryId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setBoolean(6, false);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        String query = "UPDATE product SET product_category_id = ?, product_name = ?, description = ?, price = ?, image = ?, is_deleted = ? WHERE id = ?";
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, product.getProductCategoryId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setBoolean(6, product.isDeleted());
            preparedStatement.setInt(7, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "UPDATE product SET is_deleted = true WHERE id = ?";
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductDTO> searchByTerm(String searchTerm) {
        List<ProductDTO> products = new ArrayList<>();
        String query = "SELECT p.id, p.product_category_id, p.product_name, p.description, p.price, p.image, p.created_at, p.is_deleted, \n" +
                "                pc.product_name as category_name FROM product p JOIN product_category pc ON p.product_category_id = pc.id\n" +
                "                WHERE p.product_name LIKE ?  AND p.is_deleted = 0;";

        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, "%" + searchTerm + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProductDTO productDTO = new ProductDTO(
                        resultSet.getInt("id"),
                        resultSet.getInt("product_category_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("image"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getBoolean("is_deleted"),
                        resultSet.getString("category_name")
                );
                products.add(productDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
