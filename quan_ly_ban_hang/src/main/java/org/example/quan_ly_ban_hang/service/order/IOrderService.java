package org.example.quan_ly_ban_hang.service.order;

import org.example.quan_ly_ban_hang.DTO.OrderDTO;

import org.example.quan_ly_ban_hang.DTO.ProductDetailDTO;
import org.example.quan_ly_ban_hang.model.Order;

import java.util.List;

public interface IOrderService {
    void  add(Order order);
    void delete(int id);
    void update(Order order);
    List<OrderDTO> findByName(String name);
    List<OrderDTO> findAll();
    List<ProductDetailDTO> getProductDetail(int orderId);
    void approveOrder(int id);
    void checkStatusChanges();
}
