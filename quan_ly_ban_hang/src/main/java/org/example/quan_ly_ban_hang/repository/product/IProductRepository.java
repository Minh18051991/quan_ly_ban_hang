package org.example.quan_ly_ban_hang.repository.product;


import org.example.quan_ly_ban_hang.dto.ProductDTO;
import org.example.quan_ly_ban_hang.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> finAll();

    Product findById(int editId);

    void save(Product newProduct);

    void update(Product updatedProduct);

    void deleteById(int deleteId);

    List<ProductDTO> searchByTerm(String searchTerm);
}

