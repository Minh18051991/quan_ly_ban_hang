package org.example.quan_ly_ban_hang.repository.product_dto;

import org.example.quan_ly_ban_hang.model.ProductNewDTO;
import org.example.quan_ly_ban_hang.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductNewDTORepository implements IProductNewDTORepository {
    private static final String SELECT_PRODUCT_NEW = "SELECT p.id, p.image, p.product_name, p.description, p.price, SUM(s.quantity) AS total_quantity, pc.product_name as category_name, MAX(s.created_at) AS latest_created_at\n" +
            "FROM stock s\n" +
            "JOIN product p ON s.product_id = p.id\n" +
            "JOIN product_category pc ON p.product_category_id = pc.id\n" +
            "GROUP BY p.id\n" +
            "ORDER BY latest_created_at DESC\n" +
            "LIMIT 4;";
    private static final String SELECT_PRODUCT_ALL = "SELECT p.id, p.image, p.product_name, p.description, p.price, SUM(s.quantity) AS total_quantity, pc.product_name as category_name, MAX(s.created_at) AS latest_created_at\n" +
            "FROM stock s\n" +
            "JOIN product p ON s.product_id = p.id\n" +
            "JOIN product_category pc ON p.product_category_id = pc.id\n" +
            "GROUP BY p.id\n";
    private static final String PRODUCT_DETAILS = "SELECT p.id, p.image, p.product_name, p.description, p.price, SUM(s.quantity) AS total_quantity, pc.product_name as category_name, MAX(s.created_at) AS latest_created_at\n" +
            "FROM stock s\n" +
            "JOIN product p ON s.product_id = p.id\n" +
            "JOIN product_category pc ON p.product_category_id = pc.id\n" +
            "where p.id = ?\n" +
            "GROUP BY p.id;";
    private static final String PRODUCT_PURCHASED = "SELECT p.id, p.product_name, p.price, p.image, SUM(od.quantity) AS Total_Purchased\n" +
            "FROM order_details od\n" +
            "JOIN product p ON od.product_id = p.id\n" +
            "GROUP BY od.product_id\n" +
            "ORDER BY Total_Purchased DESC\n" +
            "limit 4    ;";
    @Override
    public List<ProductNewDTO> findAllProductNewDTO() {
        List<ProductNewDTO> productNewDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_NEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String image = resultSet.getString("image");
                String name = resultSet.getString("product_name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                DecimalFormat df = new DecimalFormat("#,###.##"); // Định dạng với dấu phẩy và hai chữ số thập phân
                String formattedPrice = df.format(price);
                int totalQuantity = resultSet.getInt("total_quantity");
                String categoryName = resultSet.getString("category_name");
                String date = resultSet.getString("latest_created_at");

                ProductNewDTO productNewDTO = new ProductNewDTO(id, name, description, formattedPrice, totalQuantity, categoryName, image, date);
                productNewDTOList.add(productNewDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return productNewDTOList;
    }

    @Override
    public List<ProductNewDTO> findAllProduct() {
        List<ProductNewDTO> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String imageUrl = resultSet.getString("image");
                String name = resultSet.getString("product_name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                DecimalFormat df = new DecimalFormat("#,###.##"); // Định dạng với dấu phẩy và hai chữ số thập phân
                String formattedPrice = df.format(price);
                int totalQuantity = resultSet.getInt("total_quantity");
                String categoryName = resultSet.getString("category_name");
                String date = resultSet.getString("latest_created_at");

                ProductNewDTO productNewDTO = new ProductNewDTO(id, name, description, formattedPrice, totalQuantity, categoryName, imageUrl, date);
                productList.add(productNewDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return productList;
    }

    @Override
    public ProductNewDTO productDetails(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(PRODUCT_DETAILS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productImage = resultSet.getString("image");
                String productName = resultSet.getString("product_name");
                String productDescription = resultSet.getString("description");
                double productPrice = resultSet.getDouble("price");
                DecimalFormat df = new DecimalFormat("#,###.##");
                String formattedPrice = df.format(productPrice);
                int totalQuantity = resultSet.getInt("total_quantity");
                String categoryName = resultSet.getString("category_name");
                String date = resultSet.getString("latest_created_at");
                ProductNewDTO productDetails = new ProductNewDTO(productId, productName, productDescription, formattedPrice, totalQuantity, categoryName, productImage, date);
                return productDetails;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public List<ProductNewDTO> productPurchasedMost() {
        List<ProductNewDTO> productPurchasedList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(PRODUCT_PURCHASED);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productImage = resultSet.getString("image");
                String productName = resultSet.getString("product_name");
                double productPrice = resultSet.getDouble("price");
                DecimalFormat df = new DecimalFormat("#,###.##");
                String formattedPrice = df.format(productPrice);
                int total_Purchased = resultSet.getInt("Total_Purchased");

                ProductNewDTO productPurchased = new ProductNewDTO(productId, productName, formattedPrice, productImage, total_Purchased);
                productPurchasedList.add(productPurchased);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productPurchasedList;
    }
}
