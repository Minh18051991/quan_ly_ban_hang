package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.model.Permission;
import org.example.quan_ly_ban_hang.service.permission.IPermissionService;
import org.example.quan_ly_ban_hang.service.permission.PermissionService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/permissions")
public class PermissionController extends HttpServlet {
    private final IPermissionService permissionService = new PermissionService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            List<Permission> permissions = permissionService.findAll();
            request.setAttribute("permissions", permissions);
            request.getRequestDispatcher("/views/permission/list.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Permission permission = permissionService.findById(id);
            request.setAttribute("permission", permission);
            request.getRequestDispatcher("/views/permission/edit.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("save".equals(action)) {
            int roleId = Integer.parseInt(request.getParameter("roleId"));
            int accountId = Integer.parseInt(request.getParameter("accountId"));
            Permission permission = new Permission(roleId, accountId);
            permissionService.save(permission);
            response.sendRedirect("/permissions");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            int roleId = Integer.parseInt(request.getParameter("roleId"));
            int accountId = Integer.parseInt(request.getParameter("accountId"));
            Permission permission = new Permission(id, roleId, accountId);
            permissionService.update(permission);
            response.sendRedirect("/permissions");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            permissionService.delete(id);
            response.sendRedirect("/permissions");
        }
    }
}