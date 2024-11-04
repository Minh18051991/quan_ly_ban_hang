<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Sản Phẩm - Điện Máy XYZ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet"> <!-- Thêm phông chữ tùy chỉnh -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
        }
    </style>
</head>
<body>

<div class="container mt-4 min-vh-100">
    <h2 class="mb-4">Thêm Sản Phẩm Mới</h2>
    <form action="/products?action=add" method="post">
        <div class="form-group">
            <label for="categoryId">Chọn loại sản phẩm:</label>
            <select class="form-control" id="categoryId" name="categoryId" required>
                <option value="" disabled selected>Chọn loại sản phẩm</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.productName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="productName">Tên sản phẩm:</label>
            <input type="text" class="form-control" id="productName" name="productName" required>
        </div>

        <div class="form-group">
            <label for="description">Mô tả:</label>
            <textarea class="form-control" id="description" name="description" required></textarea>
        </div>

        <div class="form-group">
            <label for="price">Giá:</label>
            <input type="number" class="form-control" id="price" name="price" required>
        </div>

        <div class="form-group">
            <label for="imageUrl">Đường dẫn hình ảnh:</label>
            <input type="text" class="form-control" id="imageUrl" name="imageUrl" placeholder="Nhập URL của hình ảnh" required>
        </div>

        <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
