<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh Sửa Thông Tin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom styles */
        body {
            min-height: 100vh; /* Đảm bảo chiều cao tối thiểu cho body */
            color: white;
            filter: brightness(0.8); /* Giảm độ sáng của hình nền */
            display: flex;
            flex-direction: column;
            justify-content: space-between; /* Đảm bảo các phần luôn ở dưới cùng */
        }

        header {
            z-index: 1; /* Đảm bảo header nằm trên cùng */
        }

       

        .nav {
            margin-right: auto; /* Đẩy các phần bên trái về phía trái */
        }



        footer {
            background-color: #343a40; /* Màu nền của footer */
            color: white; /* Màu chữ trong footer */
        }



    </style>
</head>
<body>
<!-- header -->
<header class="bg-primary text-white">
    <div class="container d-flex justify-content-between align-items-center py-3">
        <h1 class="h4">Điện Máy XYZ</h1>
        <nav class="nav">
            <a class="nav-link text-white" href="#search">Tìm Kiếm</a>
            <a class="nav-link text-white" href="#about">Giới Thiệu</a>
            <a class="nav-link text-white" href="#products">Sản Phẩm</a>
            <a class="nav-link text-white" href="#contact">Liên Hệ</a>
            <a class="nav-link text-white" href="#cart">Giỏ Hàng</a>
            <a class="nav-link text-white" href="#admin">Admin</a>
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
<!-- body -->
<div class="container">
    <h2 class="mt-5">Chỉnh Sửa Thông Tin</h2>

    <!-- Hiển thị thông báo lỗi nếu có -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <form action="/auth?action=update" method="post">
        <input type="hidden" name="action" value="update">

        <div class="form-group">
            <label for="name">Tên:</label>
            <input type="text" class="form-control" id="name" name="name" value="${customer.name}" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="${customer.email}" required>
        </div>
        <div class="form-group">
            <label for="address">Địa Chỉ:</label>
            <input type="text" class="form-control" id="address" name="address" value="${customer.address}" required>
        </div>
        <div class="form-group">
            <label for="phone">Số Điện Thoại:</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${customer.phone}" required>
        </div>
        <div class="form-group">
            <label for="oldPassword">Mật Khẩu Cũ:</label>
            <input type="password" class="form-control" id="oldPassword" name="oldPassword" required>
        </div>
        <div class="form-group">
            <label for="newPassword">Mật Khẩu Mới (để trống nếu không thay đổi):</label>
            <input type="password" class="form-control" id="newPassword" name="newPassword">
        </div>
        <button type="submit" class="btn btn-primary">Cập Nhật(nhập mật khẩu để xác định cập nhập)</button>
    </form>
</div>
<footer class="py-4">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h5>Thông Tin Liên Hệ</h5>
                <p>Địa chỉ: Số 123, Đường ABC, Quận 1, TP.HCM</p>
                <p>Email: lienhe@dienmayxyz.com</p>
                <p>Điện thoại: 0123 456 789</p>
            </div>
            <div class="col-md-6 text-md-right">
                <p>&copy; 2024 Điện Máy XYZ - Bản quyền thuộc về XYZ Corp.</p>
            </div>
        </div>
    </div>
</footer>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>