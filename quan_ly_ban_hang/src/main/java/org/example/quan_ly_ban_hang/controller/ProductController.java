package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.model.ProductNewDTO;
import org.example.quan_ly_ban_hang.serviceDTO.IProductNewDTOService;
import org.example.quan_ly_ban_hang.serviceDTO.ProductNewDTOService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private IProductNewDTOService productNewDTOService = new ProductNewDTOService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "product-new":
                showProductNewDTO(req, resp);
                break;
            case "product_details":
                productDetails(req,resp);
                break;
            case "product-purchased":
                productPurchasedList(req,resp);
                break;
            default:
                showProductList(req, resp);
                break;
        }
    }

    private void productPurchasedList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("productPurchasedList",productNewDTOService.productPurchasedMost());
        try {
            req.getRequestDispatcher("views/product_list/product-purchased.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showProductList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("productList", productNewDTOService.findAllProduct());
        try {
            req.getRequestDispatcher("views/product_list/product_list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showProductNewDTO(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("productNewList", productNewDTOService.findAllProductNewDTO());
        try {
            req.getRequestDispatcher("/views/product-new/product-new-dto.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void productDetails(HttpServletRequest req, HttpServletResponse resp) {
        int productId = Integer.parseInt(req.getParameter("id"));
        ProductNewDTO productDetails = productNewDTOService.productDetails(productId);
        req.setAttribute("product",productDetails);
        try {
            req.getRequestDispatcher("/views/product_list/product_details.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
