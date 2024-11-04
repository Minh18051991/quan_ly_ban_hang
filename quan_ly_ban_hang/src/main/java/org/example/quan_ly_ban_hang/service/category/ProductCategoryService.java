package org.example.quan_ly_ban_hang.service.category;

import org.example.quan_ly_ban_hang.model.ProductCategory;
import org.example.quan_ly_ban_hang.repository.category.IProductCategoryRepository;
import org.example.quan_ly_ban_hang.repository.category.ProductCategoryRepository;

import java.util.List;

public class ProductCategoryService implements IProductCategoryService {
    private IProductCategoryRepository productCategoryRepository = new ProductCategoryRepository();

    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.getAllCategories();
    }
}
