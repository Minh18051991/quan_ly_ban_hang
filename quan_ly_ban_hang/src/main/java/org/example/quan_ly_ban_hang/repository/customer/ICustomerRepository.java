package org.example.quan_ly_ban_hang.repository.customer;

import org.example.quan_ly_ban_hang.dto.CustomerPurchaseDTO;
import org.example.quan_ly_ban_hang.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    int save(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();
    void update(Customer customer);
    void delete(int id);

    List<Customer> GetAllCustomers(int page, int pageSize);


    List<Customer> FindCustomerByName(String name);

    boolean deleteCustomer(int id);

    List<CustomerPurchaseDTO> GetTopCustomersByProductCount();

    int getTotalCustomers();


}