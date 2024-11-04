<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Bán Hàng Điện Máy</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<!-- Header -->
<header class="bg-primary text-white">
    <div class="container d-flex justify-content-between align-items-center py-3">
        <h1 class="h4">Điện Máy XYZ</h1>
        <nav class="nav">
            <a class="nav-link text-white" href="#search">Tìm Kiếm</a>
            <a class="nav-link text-white" href="#about">Giới Thiệu</a>
            <a class="nav-link text-white" href="#products">Sản Phẩm</a>
            <a class="nav-link text-white" href="#contact">Liên Hệ</a>
            <a class="nav-link text-white" href="#cart">Giỏ Hàng</a>
        </nav>
        <div class="btn-group">
            <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Đăng Nhập
            </button>
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="#profile">Thông Tin Tài Khoản</a>
                <a class="dropdown-item" href="#logout">Đăng Xuất</a>
            </div>
        </div>
    </div>
</header>

<!-- Body -->
<div class="container mt-4">
    <h1 class="text-center mb-4">Danh sách sản phẩm mới nhất</h1>
    <div class="row">
        <c:forEach items="${productNewList}" var="product">
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="${product.imageUrl}" class="card-img-top" alt="${product.name}">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">Giá: <strong>${product.price}</strong> VNĐ</p>
                        <p class="card-text">Số lượng: <strong>${product.quantity}</strong></p>
                        <p class="card-text">Giới thiệu: <strong>${product.description}</strong></p>
                        <p class="card-text">Loại sản phẩm: <strong>${product.categoryName}</strong></p>
                        <p class="card-text">Ngày nhập: <strong>${product.date}</strong></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
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