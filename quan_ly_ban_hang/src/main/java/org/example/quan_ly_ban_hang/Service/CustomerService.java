package org.example.quan_ly_ban_hang.Service;

import org.example.quan_ly_ban_hang.DTO.CustomerPurchaseDTO;
import org.example.quan_ly_ban_hang.model.Customer;
import org.example.quan_ly_ban_hang.repository.CustomerRepository;
import org.example.quan_ly_ban_hang.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

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
