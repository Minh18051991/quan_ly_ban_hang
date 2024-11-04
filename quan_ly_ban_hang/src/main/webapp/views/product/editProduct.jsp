<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh Sửa Sản Phẩm - Điện Máy XYZ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<!-- Header -->
<header class="bg-primary text-white">
    <div class="container d-flex justify-content-between align-items-center py-3">
        <h1 class="h4">Điện Máy XYZ</h1>
        <!-- Nav and Login Menu as in productList.jsp -->
    </div>
</header>

<!-- Body -->
<div class="container mt-4">
    <h2>Chỉnh Sửa Sản Phẩm</h2>
    <form action="/products?action=update" method="post">
        <input type="hidden" name="id" value="${product.id}">

        <div class="form-group">
            <label for="categoryId">Mã Loại Sản Phẩm:</label>
            <input type="number" class="form-control" id="categoryId" name="categoryId" value="${product.productCategoryId}" required>
        </div>

        <div class="form-group">
            <label for="productName">Tên Sản Phẩm:</label>
            <input type="text" class="form-control" id="productName" name="productName" value="${product.productName}" required>
        </div>

        <div class="form-group">
            <label for="description">Mô Tả:</label>
            <textarea class="form-control" id="description" name="description" required>${product.description}</textarea>
        </div>

        <div class="form-group">
            <label for="price">Giá:</label>
            <input type="number" class="form-control" id="price" name="price" value="${product.price}" required>
        </div>

        <div class="form-group">
            <label for="imageUrl">Hình Ảnh:</label>
            <input type="text" class="form-control" id="imageUrl" name="imageUrl" value="${product.image}" required>
        </div>

        <button type="submit" class="btn btn-primary">Cập Nhật</button>
        <a href="product?action=list" class="btn btn-secondary">Hủy</a>
    </form>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center py-3">
    <p class="mb-0">&copy; 2023 Điện Máy XYZ. Tất cả quyền được bảo lưu.</p>
    <p>Liên hệ: support@dienmayxyz.com | Số điện thoại: 0123-456-789</p>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
