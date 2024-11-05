package org.example.quan_ly_ban_hang.repository.product_dto;

import org.example.quan_ly_ban_hang.model.ProductNewDTO;

import java.util.List;

public interface IProductNewDTORepository {
    List<ProductNewDTO> findAllProductNewDTO();

    List<ProductNewDTO> findAllProduct();

    ProductNewDTO productDetails(int id);

    List<ProductNewDTO> productPurchasedMost();
}
