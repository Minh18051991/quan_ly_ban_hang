package org.example.quan_ly_ban_hang.controller;


import org.example.quan_ly_ban_hang.dto.OrderDTO;
import org.example.quan_ly_ban_hang.dto.ProductDetailDTO;

import org.example.quan_ly_ban_hang.service.order.IOrderService;
import org.example.quan_ly_ban_hang.service.order.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orderController", value = "/order")
public class OrderController extends HttpServlet {
    IOrderService orderService = new OrderService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "searchByName":
                getByName(req, resp);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "delete":
                deleteOrder(req, resp);
                break;
            case "orderDetail":
                getProductDetail(req, resp);
                break;
            case "approve":
                approveOrder(req, resp);
                break;

            default:
                showListOrder(req, resp);
                break;
        }
    }

    private void getByName(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        List<OrderDTO> orders = orderService.findByName(name);
        req.setAttribute("orderDTO", orders);
        try {
            req.getRequestDispatcher("views/order/search.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListOrder(HttpServletRequest req, HttpServletResponse resp) {
        List<OrderDTO> listOrder = orderService.findAll();
        req.setAttribute("listOrder", listOrder);
        try {
            req.getRequestDispatcher("views/order/list.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        orderService.delete(id);
        try {
            resp.sendRedirect(req.getContextPath() + "/order");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getProductDetail(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        List<ProductDetailDTO> productDetails = orderService.getProductDetail(id);
        req.setAttribute("productDetailDTO", productDetails);
        try {
            req.getRequestDispatcher("views/order/detail.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void approveOrder(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        orderService.approveOrder(id);
        orderService.checkStatusChanges();
        try {
            resp.sendRedirect(req.getContextPath() + "/order");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
