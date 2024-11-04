package org.example.quan_ly_ban_hang.service.customer;

import org.example.quan_ly_ban_hang.DTO.CustomerPurchaseDTO;
import org.example.quan_ly_ban_hang.model.Customer;
import org.example.quan_ly_ban_hang.repository.customer.CustomerRepository;
import org.example.quan_ly_ban_hang.repository.customer.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public int save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }
    @Override
    public List<Customer> GetAllCustomers(int page, int pageSize) {
        return customerRepository.GetAllCustomers(page, pageSize);
    }


    @Override
    public List<Customer> FindCustomerByName(String name) {
        return customerRepository.FindCustomerByName(name);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public List<CustomerPurchaseDTO> GetTopCustomersByProductCount() {
        return customerRepository.GetTopCustomersByProductCount();
    }

    @Override
    public int getTotalCustomers() {
        return customerRepository.getTotalCustomers();
    }
}