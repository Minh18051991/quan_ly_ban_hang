package org.example.quan_ly_ban_hang.repository.category;

import org.example.quan_ly_ban_hang.model.ProductCategory;

import java.util.List;

public interface IProductCategoryRepository {
    List<ProductCategory> getAllCategories();
}
