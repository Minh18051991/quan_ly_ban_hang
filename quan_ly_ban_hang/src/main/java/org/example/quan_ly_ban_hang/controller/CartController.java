package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.model.Cart;
import org.example.quan_ly_ban_hang.model.ProductNewDTO;
import org.example.quan_ly_ban_hang.service.serviceDTO.IProductNewDTOService;
import org.example.quan_ly_ban_hang.service.serviceDTO.ProductNewDTOService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet (name = "CardController", value = "/cart")
public class CartController extends HttpServlet {
    private IProductNewDTOService productNewDTOService = new ProductNewDTOService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "card-add":
                addProduct(req,resp);
                HttpSession session = req.getSession();
                Cart cart = (Cart) session.getAttribute("cart");
                req.setAttribute("cart", cart);
                req.getRequestDispatcher("/views/cart/list.jsp").forward(req, resp);
                break;
        }
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductNewDTO product = productNewDTOService.productDetails(id);
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.addProduct(product,1);
    }

}
