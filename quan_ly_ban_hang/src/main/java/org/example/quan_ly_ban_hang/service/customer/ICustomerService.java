package org.example.quan_ly_ban_hang.service.customer;

import org.example.quan_ly_ban_hang.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id, boolean isAdmin, int userId);
    void save(Customer customer);
    void update(Customer customer, int userId);
    void delete(int id, boolean isAdmin);
}