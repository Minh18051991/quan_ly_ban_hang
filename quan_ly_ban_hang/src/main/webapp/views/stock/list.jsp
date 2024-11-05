<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/4/2024
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="org.example.quan_ly_ban_hang.model.Stock" %>
<%@ page import="org.example.quan_ly_ban_hang.dto.StockDTO" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
        }
    </style>
</head>
<body>
<div class="container my-5">
    <h1 class="mb-4">Inventory Management</h1>
    <a href="/stock?action=add" class="btn btn-primary mb-3">Add New Product</a>
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<StockDTO> stockDTOList = (List<StockDTO>) request.getAttribute("stockList");
            for (StockDTO stockDTO : stockDTOList) {
        %>
        <tr>
            <td><%= stockDTO.getId() %></td>
            <td><%= stockDTO.getProductID() %></td>
            <td><%= stockDTO.getProductName()%></td>
            <td><%= stockDTO.getQuantity() %></td>
            <td>
                <a href="/stock?action=edit&id=<%= stockDTO.getId() %>" class="btn btn-warning btn-sm">Update</a>
                <a href="/stock?action=delete&id=<%= stockDTO.getId() %>" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>