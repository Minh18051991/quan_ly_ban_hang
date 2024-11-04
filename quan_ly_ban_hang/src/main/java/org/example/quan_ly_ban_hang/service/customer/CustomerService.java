package org.example.quan_ly_ban_hang.service.customer;

import org.example.quan_ly_ban_hang.model.Customer;
import org.example.quan_ly_ban_hang.repository.customer.ICustomerRepository;
import org.example.quan_ly_ban_hang.repository.customer.CustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    @Override
    public List<Customer> findAll() {
        // Chỉ Admin mới có quyền xem tất cả khách hàng
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id, boolean isAdmin, int userId) {
        if (isAdmin || id == userId) {
            return customerRepository.findById(id);
        }
        throw new SecurityException("Bạn không có quyền xem thông tin này.");
    }

    @Override
    public void save(Customer customer) {
        // Chỉ người dùng mới có thể thêm thông tin của mình
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer, int userId) {
        // Kiểm tra xem người dùng có quyền chỉnh sửa không
        if (customer.getId() == userId) {
            customerRepository.update(customer);
        } else {
            throw new SecurityException("Bạn không có quyền chỉnh sửa thông tin này.");
        }
    }

    @Override
    public void delete(int id, boolean isAdmin) {
        // Chỉ Admin mới có quyền xóa
        if (isAdmin) {
            customerRepository.delete(id);
        } else {
            throw new SecurityException("Bạn không có quyền xóa khách hàng.");
        }
    }
}