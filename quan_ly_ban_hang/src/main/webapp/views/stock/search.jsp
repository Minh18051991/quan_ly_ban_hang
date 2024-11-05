<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/4/2024
  Time: 1:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="org.example.quan_ly_ban_hang.model.Stock" %>
<%@ page import="org.example.quan_ly_ban_hang.dto.StockDTO" %>
<html>
<head>
  <title>Search Stock</title>
</head>
<body>
<h1>Search Results</h1>
<a href="/stock?action=searchForm">Back to Search Form</a>
<table border="1">  <tr>
    <th>ID</th>
    <th>Product ID</th>
    <th>Quantity</th>
  </tr>
  <%
    List<StockDTO> stockDTOList = (List<StockDTO>) request.getAttribute("stockList");
    if (stockDTOList != null && !stockDTOList.isEmpty()) {
      for (StockDTO stock : stockDTOList) {
  %>
  <tr>
    <td><%= stock.getId() %></td>
    <td><%= stock.getProductID() %></td>
    <td><%= stock.getQuantity() %></td>
  </tr>
  <%
    }
  } else {
  %>
  <tr>
    <td colspan="3">No results found.</td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
