package org.example.quan_ly_ban_hang.service.serviceDTO;

import org.example.quan_ly_ban_hang.model.ProductNewDTO;

import java.util.List;

public interface IProductNewDTOService {
    List<ProductNewDTO> findAllProductNewDTO();

    List<ProductNewDTO> findAllProduct();

    ProductNewDTO productDetails(int id);

    List<ProductNewDTO> productPurchasedMost();
}
