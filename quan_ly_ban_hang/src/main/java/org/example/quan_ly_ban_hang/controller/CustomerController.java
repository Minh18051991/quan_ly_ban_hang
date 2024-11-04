package org.example.quan_ly_ban_hang.controller;

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

@WebServlet("/customers")
public class CustomerController extends HttpServlet {
    private final ICustomerService customerService = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            List<Customer> customers = customerService.findAll();
            request.setAttribute("customers", customers);
            request.getRequestDispatcher("/views/customer/list.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Customer customer = customerService.findById(id);
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/views/customer/edit.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("save".equals(action)) {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            boolean isDeleted = Boolean.parseBoolean(request.getParameter("isDeleted"));
            Customer customer = new Customer(name, address, phone, email, isDeleted);
            customerService.save(customer);
            response.sendRedirect("/customers");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            boolean isDeleted = Boolean.parseBoolean(request.getParameter("isDeleted"));
            Customer customer = new Customer(id, name, address, phone, email, isDeleted);
            customerService.update(customer);
            response.sendRedirect("/customers");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            customerService.delete(id);
            response.sendRedirect("/customers");
        }
    }
}