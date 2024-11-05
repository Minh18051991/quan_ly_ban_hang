package org.example.quan_ly_ban_hang.service.product;


import org.example.quan_ly_ban_hang.dto.ProductDTO;
import org.example.quan_ly_ban_hang.model.Product;
import org.example.quan_ly_ban_hang.repository.product.IProductRepository;
import org.example.quan_ly_ban_hang.repository.product.ProductRepository;

import java.util.List;

public class    ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> getAllProducts() {
        return productRepository.finAll();
    }

    @Override
    public Product getProductById(int editId) {
        return productRepository.findById(editId);
    }

    @Override
    public void addProduct(Product newProduct) {
        productRepository.save(newProduct);
    }

    @Override
    public void updateProduct(Product updatedProduct) {
        productRepository.update(updatedProduct);
    }

    @Override
    public void softDeleteProduct(int deleteId) {
        productRepository.deleteById(deleteId);
    }

    @Override
    public List<ProductDTO> searchProducts(String searchTerm) {
        return  productRepository.searchByTerm(searchTerm);
    }
}
