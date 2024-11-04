package org.example.quan_ly_ban_hang.serviceDTO;

import org.example.quan_ly_ban_hang.model.ProductNewDTO;
import org.example.quan_ly_ban_hang.repository.IProductNewDTORepository;
import org.example.quan_ly_ban_hang.repository.ProductNewDTORepository;

import java.util.List;

public class ProductNewDTOService implements IProductNewDTOService{
    private IProductNewDTORepository productNewDTORepository = new ProductNewDTORepository();
    @Override
    public List<ProductNewDTO> findAllProductNewDTO() {
        return productNewDTORepository.findAllProductNewDTO();
    }

    @Override
    public List<ProductNewDTO> findAllProduct() {
        return productNewDTORepository.findAllProduct();
    }

    @Override
    public ProductNewDTO productDetails(int id) {
        return productNewDTORepository.productDetails(id);
    }

    @Override
    public List<ProductNewDTO> productPurchasedMost() {
        return productNewDTORepository.productPurchasedMost();
    }
}
