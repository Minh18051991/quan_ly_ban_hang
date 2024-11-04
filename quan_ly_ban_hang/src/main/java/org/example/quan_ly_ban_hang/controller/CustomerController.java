package org.example.quan_ly_ban_hang.controller;


import org.example.quan_ly_ban_hang.DTO.CustomerPurchaseDTO;
import org.example.quan_ly_ban_hang.model.Customer;
import org.example.quan_ly_ban_hang.service.customer.CustomerService;
import org.example.quan_ly_ban_hang.service.customer.ICustomerService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "AdminController", urlPatterns = {"/customer"})
public class CustomerController extends HttpServlet {
    private ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        int page = 1; // Default page
        int pageSize = 5; // Number of customers per page

        String pageParam = req.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            page = Integer.parseInt(pageParam);
        }

        try {
            switch (action) {
                case "search":
                    searchCustomer(req, resp, page, pageSize);
                    break;
                case "topCustomers":
                    listTopCustomers(req, resp);
                    break;
                default:
                    listCustomers(req, resp, page, pageSize);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/customer");
        }
    }

    private void listCustomers(HttpServletRequest req, HttpServletResponse resp, int page, int pageSize) throws ServletException, IOException {
        List<Customer> customers = customerService.GetAllCustomers(page, pageSize);
        int totalCustomers = customerService.getTotalCustomers();
        int totalPages = (int) Math.ceil((double) totalCustomers / pageSize);

        req.setAttribute("customers", customers);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);
        req.getRequestDispatcher("/views/customer/customerList.jsp").forward(req, resp);
    }

    private void searchCustomer(HttpServletRequest req, HttpServletResponse resp, int page, int pageSize) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Customer> customers = customerService.FindCustomerByName(name);

        // Calculate total pages based on search results
        int totalCustomers = customers.size(); // Total customers found in search
        int totalPages = (int) Math.ceil((double) totalCustomers / pageSize);

        // Pagination logic
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalCustomers);

        if (startIndex >= totalCustomers) {
            startIndex = totalCustomers - pageSize; // Adjust if page exceeds total
        }

        if (startIndex < 0) {
            startIndex = 0; // Ensure no negative index
        }

        List<Customer> paginatedCustomers = customers.subList(startIndex, endIndex);

        req.setAttribute("customers", paginatedCustomers);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);

        if (!paginatedCustomers.isEmpty()) {
            req.getRequestDispatcher("/views/customer/customerList.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Không tìm thấy khách hàng với tên: " + name);
            listCustomers(req, resp, 1, pageSize);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean isDeleted = customerService.deleteCustomer(id);
            if (isDeleted) {
                req.setAttribute("message", "Khách hàng đã được xóa thành công.");
            } else {
                req.setAttribute("message", "Không thể xóa khách hàng.");
            }
            listCustomers(req, resp, 1, 5);
        }
    }

    private void listTopCustomers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1; // Trang mặc định
        int pageSize = 5; // Số lượng khách hàng hàng đầu hiển thị trên mỗi trang

        // Lấy tham số trang từ yêu cầu
        String pageParam = req.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            page = Integer.parseInt(pageParam); // Chuyển đổi tham số trang sang số nguyên
        }

        // Lấy danh sách khách hàng hàng đầu từ dịch vụ
        List<CustomerPurchaseDTO> topCustomers = customerService.GetTopCustomersByProductCount();
        // Tính toán tổng số khách hàng
        int totalCustomers = topCustomers.size();
        // Tính số trang dựa trên tổng số khách hàng và kích thước trang
        int totalPages = (int) Math.ceil((double) totalCustomers / pageSize);

        // Logic phân trang
        int startIndex = (page - 1) * pageSize; // Tính chỉ số bắt đầu
        int endIndex = Math.min(startIndex + pageSize, totalCustomers); // Tính chỉ số kết thúc
        if (startIndex < 0) startIndex = 0; // Đảm bảo chỉ số bắt đầu không âm
        if (startIndex >= totalCustomers) startIndex = totalCustomers - pageSize; // Điều chỉnh nếu trang vượt quá tổng số

        // Lấy danh sách khách hàng hàng đầu đã phân trang
        List<CustomerPurchaseDTO> paginatedTopCustomers = topCustomers.subList(startIndex, endIndex);
        req.setAttribute("topCustomers", paginatedTopCustomers);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);
        req.getRequestDispatcher("/views/customer/topCustomers.jsp").forward(req, resp);
    }


}

