package org.example.quan_ly_ban_hang.repository.category;

import org.example.quan_ly_ban_hang.model.ProductCategory;
import org.example.quan_ly_ban_hang.repository.BaseRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryRepository implements IProductCategoryRepository {

    @Override
    public List<ProductCategory> getAllCategories() {
        List<ProductCategory> categories = new ArrayList<>();
        String query = "SELECT * FROM product_category";

        try (Connection connection = BaseRepository.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("product_name");
                categories.add(new ProductCategory(id, productName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
