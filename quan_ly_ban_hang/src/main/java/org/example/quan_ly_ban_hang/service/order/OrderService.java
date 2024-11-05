package org.example.quan_ly_ban_hang.service.order;

import org.example.quan_ly_ban_hang.dto.OrderDTO;
import org.example.quan_ly_ban_hang.dto.ProductDetailDTO;
import org.example.quan_ly_ban_hang.model.Order;
import org.example.quan_ly_ban_hang.repository.order.IOrderRepository;
import org.example.quan_ly_ban_hang.repository.order.OrderRepository;

import java.util.List;

public class OrderService implements IOrderService {
    IOrderRepository orderRepository = new OrderRepository();

    public OrderService() {
    }

    @Override
    public void add(Order order) {

    }

    @Override
    public void delete(int id) {
        orderRepository.delete(id);
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public List<OrderDTO> findByName(String name) {
        return orderRepository.findByName(name);
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<ProductDetailDTO> getProductDetail(int orderId) {
        return orderRepository.getProductDetail(orderId)  ;
    }

    @Override
    public void approveOrder(int id) {
        orderRepository.approveOrder(id);
    }

    @Override
    public void checkStatusChanges() {
        orderRepository.checkStatusChanges();
    }


}
