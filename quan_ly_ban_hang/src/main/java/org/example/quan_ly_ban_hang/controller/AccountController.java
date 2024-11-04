package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.model.Account;
import org.example.quan_ly_ban_hang.service.account.AccountService;
import org.example.quan_ly_ban_hang.service.account.IAccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/accounts")
public class AccountController extends HttpServlet {
    private final IAccountService accountService = new AccountService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            List<Account> accounts = accountService.findAll();
            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("/views/account/list.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Account account = accountService.findById(id);
            request.setAttribute("account", account);
            request.getRequestDispatcher("/views/account/edit.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("save".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Account account = new Account(username, password);
            accountService.save(account);
            response.sendRedirect("/accounts");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Account account = new Account(id, username, password);
            accountService.update(account);
            response.sendRedirect("/accounts");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            accountService.delete(id);
            response.sendRedirect("/accounts");
        }
    }
}