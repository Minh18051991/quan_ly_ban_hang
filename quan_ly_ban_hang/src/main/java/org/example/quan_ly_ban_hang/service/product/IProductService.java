package org.example.quan_ly_ban_hang.service.product;


import org.example.quan_ly_ban_hang.DTO.ProductDTO;
import org.example.quan_ly_ban_hang.model.Product;

import java.util.List;

public interface IProductService  {
    List<Product> getAllProducts();

    Product getProductById(int editId);


    void addProduct(Product newProduct);

    void updateProduct(Product updatedProduct);

    void softDeleteProduct(int deleteId);

    List<ProductDTO> searchProducts(String searchTerm);
}
