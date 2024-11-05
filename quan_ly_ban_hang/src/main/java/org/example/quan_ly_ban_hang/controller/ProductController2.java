package org.example.quan_ly_ban_hang.controller;


import org.example.quan_ly_ban_hang.dto.ProductDTO;
import org.example.quan_ly_ban_hang.model.Product;
import org.example.quan_ly_ban_hang.model.ProductCategory;
import org.example.quan_ly_ban_hang.service.category.ProductCategoryService;
import org.example.quan_ly_ban_hang.service.product.IProductService;
import org.example.quan_ly_ban_hang.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController2", urlPatterns = "/products")
public class ProductController2 extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "list":
                listProducts(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            case "addForm":
                addProductForm(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/views/product/productList.jsp").forward(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int editId = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(editId);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/views/product/editProduct.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int deleteId = Integer.parseInt(request.getParameter("id"));
        productService.softDeleteProduct(deleteId);
        response.sendRedirect("/views/product/productList.jsp");
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("keyword");
        List<ProductDTO> searchResults = productService.searchProducts(searchTerm);
        request.setAttribute("product", searchResults);
        request.getRequestDispatcher("/views/product/searchProduct.jsp").forward(request, response);
    }

    private void addProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductCategoryService productCategoryService = new ProductCategoryService();
        List<ProductCategory> categories = productCategoryService.getAllCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/views/product/addProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                addProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            default:
                listProducts(request,response);
                break;
        }
    }


    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("productName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("imageUrl");

        Product newProduct = new Product(categoryId, name, description, price, image, false);
        productService.addProduct(newProduct);
        response.sendRedirect("/products?action=list");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("productName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("imageUrl");

        Product updatedProduct = new Product(id, categoryId, name, description, price, image, false);
        productService.updateProduct(updatedProduct);
        response.sendRedirect("/products?action=list");
    }
}