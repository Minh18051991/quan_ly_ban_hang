package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.model.Role;
import org.example.quan_ly_ban_hang.service.role.IRoleService;
import org.example.quan_ly_ban_hang.service.role.RoleService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/roles")
public class RoleController extends HttpServlet {
    private final IRoleService roleService = new RoleService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            List<Role> roles = roleService.findAll();
            request.setAttribute("roles", roles);
            request.getRequestDispatcher("/views/role/list.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Role role = roleService.findById(id);
            request.setAttribute("role", role);
            request.getRequestDispatcher("/views/role/edit.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("save".equals(action)) {
            String name = request.getParameter("name");
            Role role = new Role(name);
            roleService.save(role);
            response.sendRedirect("/roles");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Role role = new Role(id, name);
            roleService.update(role);
            response.sendRedirect("/roles");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            roleService.delete(id);
            response.sendRedirect("/roles");
        }
    }
}