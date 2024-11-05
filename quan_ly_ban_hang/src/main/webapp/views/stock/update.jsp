<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.quan_ly_ban_hang.model.Stock" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Stock</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Update Stock</h1>
    <form action="/stock" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${stock.id}">
<%--        <div class="form-group">--%>
<%--            <label for="productId">Product ID:</label>--%>
<%--            <input type="text" class="form-control" id="productId" name="productId" value="${stockDTO.productId}" required>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="productName">Product Name:</label>--%>
<%--            <input type="text" class="form-control" id="productName" name="productName"  required>--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="quantity"  required>
        </div>
<%--        <div class="form-check">--%>
<%--            <input type="checkbox" class="form-check-input" id="isDeleted" name="isDeleted" <c:if test="${stockDTO.isDeleted}">checked</c:if>>--%>
<%--            <label class="form-check-label" for="isDeleted">Is Deleted</label>--%>
<%--        </div>--%>
        <button type="submit" class="btn btn-primary">Update Stock</button>
        <a href="/stock" class="btn btn-secondary">Back to Stock List</a>
    </form>
</div>

<!-- Bootstrap JavaScript -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>