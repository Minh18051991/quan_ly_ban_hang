package org.example.quan_ly_ban_hang.repository.stockRepository;

import org.example.quan_ly_ban_hang.dto.StockDTO;
import org.example.quan_ly_ban_hang.model.Stock;
import org.example.quan_ly_ban_hang.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockRepository implements IStockRepository {
    private static final String INSERT_STOCK_SQL = "insert into stock(product_id, product_name, quantity,created_at) values(?,?,?,?)";
    private static final String SELECT_STOCK_BY_ID = "SELECT * FROM stock WHERE id = ?;";
    private static final String SELECT_ALL_STOCKS = "SELECT s.id,\n" +
            "\t   p.id AS product_id,\n" +
            "       p.product_name,\n" +
            "       s.quantity,\n" +
            "       s.created_at,\n" +
            "       s.is_deleted\n" +
            "FROM stock s\n" +
            "JOIN product p ON s.product_id = p.id;";
    private static final String DELETE_STOCK_SQL = "DELETE FROM stock WHERE id = ?;";
    private static final String UPDATE_STOCK_SQL = "UPDATE stock SET quantity = ? WHERE id = ?;";

    public void insert(StockDTO stockDTO) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STOCK_SQL)) {
            preparedStatement.setInt(1, stockDTO.getProductID());
            preparedStatement.setString(2, stockDTO.getProductName());
            preparedStatement.setInt(3, stockDTO.getQuantity());
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()) );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Stock select(int id) {
        Stock stock = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STOCK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                Timestamp createdAt = rs.getTimestamp("created_at");
                boolean isDeleted = rs.getBoolean("is_deleted");
                stock = new Stock(id, productId, quantity, createdAt, isDeleted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public List<StockDTO> selectAll() {
        List<StockDTO> stocks = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STOCKS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                Timestamp createdAt = rs.getTimestamp("created_at");
                boolean isDeleted = rs.getBoolean("is_deleted");
                stocks.add(new StockDTO(id, productId, productName, quantity, createdAt, isDeleted));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    public void delete(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STOCK_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(  int quantity,int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STOCK_SQL)) {
//           preparedStatement.setString(1, productName);
           preparedStatement.setInt(1, quantity);
           preparedStatement.setInt(2, id);
           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

