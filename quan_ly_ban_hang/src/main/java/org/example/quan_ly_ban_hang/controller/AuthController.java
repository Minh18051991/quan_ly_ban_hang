package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.model.Account;
import org.example.quan_ly_ban_hang.model.Customer;
import org.example.quan_ly_ban_hang.service.account.AccountService;
import org.example.quan_ly_ban_hang.service.account.IAccountService;
import org.example.quan_ly_ban_hang.service.customer.CustomerService;
import org.example.quan_ly_ban_hang.service.customer.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
    private final IAccountService accountService = new AccountService();
    private final ICustomerService customerService = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        } else if ("register".equals(action)) {
            request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
        } else if ("logout".equals(action)) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("/views/landing_page.jsp");
        } else if ("profile".equals(action)) {
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            if (account == null) {
                response.sendRedirect("/views/auth/landing_page.jsp");
                return;
            }

            Customer customer = customerService.findById(account.getCustomerId());
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/views/auth/profile.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            if (accountService.findByUsernameAndPassword(username, password) != null) {
                request.setAttribute("error", "Tên đăng nhập đã tồn tại");
                request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
                return;
            }

            Customer customer = new Customer(name, address, phone, email, false);
            int customerId = customerService.save(customer);

            Account account = new Account();
            account.setCustomerId(customerId);
            account.setUsername(username);
            account.setPassword(password);
            account.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            account.setDeleted(false);

            accountService.save(account);
            response.sendRedirect("/auth?action=login");
        } else if ("update".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");

            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");

            if (account == null) {
                response.sendRedirect("/auth?action=login");
                return;
            }

            if (newPassword != null && !newPassword.isEmpty()) {
                if (!account.getPassword().equals(oldPassword)) {
                    request.setAttribute("error", "Mật khẩu cũ không chính xác");
                    request.getRequestDispatcher("/views/auth/profile.jsp").forward(request, response);
                    return;
                }
                account.setPassword(newPassword);
                accountService.update(account);
            }

            Customer customer = customerService.findById(account.getCustomerId());
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            customer.setPhone(phone);
            customerService.update(customer);

            // Chuyển hướng về trang chính sau khi cập nhật thành công
            response.sendRedirect("/views/home.jsp");
        } else if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Account account = accountService.findByUsernameAndPassword(username, password);
            if (account != null) {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                response.sendRedirect("/views/home.jsp");
            } else {
                request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
                request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
            }
        }
    }
}