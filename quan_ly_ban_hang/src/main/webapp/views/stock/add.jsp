<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Stock</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Add Stock</h1>
    <form action="/stock?action=add" method="post">
        <input type="hidden" name="action" value="add">
        <div class="form-group">
            <label for="productId">Product ID:</label>
            <input type="number" class="form-control" id="productId" name="productId" required>
        </div>
        <div class="form-group">
            <label for="productName">Product Name:</label>
            <input type="text" class="form-control" id="productName" name="productName" required>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" required>
        </div>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="isDeleted" name="isDeleted">
            <label class="form-check-label" for="isDeleted">Is Deleted</label>
        </div>
        <button type="submit" class="btn btn-primary">Add Stock</button>
        <a href="/stock" class="btn btn-secondary">Back to Stock List</a>
    </form>
</div>

<!-- Bootstrap JavaScript -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>