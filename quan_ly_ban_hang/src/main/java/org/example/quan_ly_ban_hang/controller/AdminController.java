//package org.example.quan_ly_ban_hang.controller;
//
//import org.example.quan_ly_ban_hang.DTO.CustomerPurchaseDTO;
//import org.example.quan_ly_ban_hang.Service.CustomerService;
//import org.example.quan_ly_ban_hang.Service.ICustomerService;
//import org.example.quan_ly_ban_hang.model.Customer;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "AdminController", urlPatterns = {"/admin"})
//public class AdminController extends HttpServlet {
//    private ICustomerService customerService = new CustomerService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//
//        try {
//            switch (action) {
//                case "search":
//                    searchCustomer(req, resp);
//                    break;
//                case "topCustomers":
//                    listTopCustomers(req, resp);
//                    break;
//                default:
//                    listCustomers(req, resp);
//                    break;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            resp.sendRedirect(req.getContextPath() + "/admin");
//        }
//    }
//
//    private void listCustomers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Customer> customers = customerService.GetAllCustomers();
//        req.setAttribute("customers", customers);
//        req.getRequestDispatcher("/views/customerList.jsp").forward(req, resp);
//    }
//
//    private void searchCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        List<Customer> customers = customerService.FindCustomerByName(name);
//
//        req.setAttribute("customers", customers);
//        if (customers != null && !customers.isEmpty()) {
//            req.getRequestDispatcher("/views/customerList.jsp").forward(req, resp);
//        } else {
//            req.setAttribute("message", "Không tìm thấy khách hàng với tên: " + name);
//            listCustomers(req, resp); // Return to the customer list
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        if ("delete".equals(action)) {
//            int id = Integer.parseInt(req.getParameter("id"));
//            boolean isDeleted = customerService.deleteCustomer(id);
//            if (isDeleted) {
//                req.setAttribute("message", "Khách hàng đã được xóa thành công.");
//            } else {
//                req.setAttribute("message", "Không thể xóa khách hàng.");
//            }
//            listCustomers(req, resp); // Return to the customer list after deletion
//        }
//    }
//
//    private void listTopCustomers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<CustomerPurchaseDTO> topCustomers = customerService.GetTopCustomersByProductCount();
//        req.setAttribute("topCustomers", topCustomers);
//        req.getRequestDispatcher("/views/topCustomers.jsp").forward(req, resp);
//    }
//}
