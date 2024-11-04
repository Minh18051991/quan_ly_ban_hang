package org.example.quan_ly_ban_hang.repository;

import org.example.quan_ly_ban_hang.DTO.CustomerPurchaseDTO;
import org.example.quan_ly_ban_hang.model.Customer;

import java.util.List;

public interface ICustomerRepository {

    List<Customer> GetAllCustomers(int page, int pageSize);


    List<Customer> FindCustomerByName(String name);

    boolean deleteCustomer(int id);

    List<CustomerPurchaseDTO> GetTopCustomersByProductCount();

    int getTotalCustomers();


}
