package org.example.quan_ly_ban_hang.service.customer;

import org.example.quan_ly_ban_hang.DTO.CustomerPurchaseDTO;
import org.example.quan_ly_ban_hang.model.Customer;

import java.util.List;

public interface ICustomerService {
    int save(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();
    void update(Customer customer);
    void delete(int id);

    // Lấy tất cả khách hàng với phân trang
    List<Customer> GetAllCustomers(int page, int pageSize);

    // Lấy tất cả khách hàng không phân trang

    // Tìm kiếm khách hàng theo tên
    List<Customer> FindCustomerByName(String name);

    // Xóa khách hàng
    boolean deleteCustomer(int id);

    // Lấy danh sách khách hàng hàng đầu theo số lượng sản phẩm đã mua
    List<CustomerPurchaseDTO> GetTopCustomersByProductCount();

    // Lấy tổng số khách hàng
    int getTotalCustomers();


}