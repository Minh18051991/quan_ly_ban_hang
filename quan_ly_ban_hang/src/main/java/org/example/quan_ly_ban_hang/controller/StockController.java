package org.example.quan_ly_ban_hang.controller;
import org.example.quan_ly_ban_hang.service.stock.IStockService;
import org.example.quan_ly_ban_hang.service.stock.StockService;
import org.example.quan_ly_ban_hang.dto.StockDTO;
import org.example.quan_ly_ban_hang.model.Stock;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StockController", value = "/stock")
public class StockController extends HttpServlet {
    IStockService stockService = new StockService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete":
                deleteStock(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "add":
                stockAddForm(request, response);
                break;
            case "view":
                viewStock(request, response);
                break;
            default:
                listStock(request, response);
                break;
        }
    }

    private void stockAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/stock/add.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                insertStock(request, response);
                break;
            case "update":
                updateStock(request, response);
                break;
            default:
                listStock(request, response);
                break;
        }
    }

    private void insertStock(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        StockDTO stockDTO = new StockDTO(productId,productName,quantity);
        stockService.insert(stockDTO);
        try {
            response.sendRedirect("stock");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StockDTO> stockDTOList = stockService.selectAll();
        request.setAttribute("stockList", stockDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/stock/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateStock(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int id = Integer.parseInt(request.getParameter("id"));

        stockService.update( quantity,id);
        response.sendRedirect("/stock");
    }

    private void deleteStock(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        stockService.delete(id);
        response.sendRedirect("stock");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Stock existingStock = stockService.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/stock/update.jsp");
        request.setAttribute("stock", existingStock);
        dispatcher.forward(request, response);
    }


    private void viewStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Stock existingStock = stockService.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/stock/search.jsp");
        request.setAttribute("stock", existingStock);
        dispatcher.forward(request, response);
    }
}


