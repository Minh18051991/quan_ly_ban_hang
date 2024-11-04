<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
<div class="container">
    <h2 class="mt-5">Đăng Ký Tài Khoản</h2>
    <form action="/auth?action=register" method="post"> <!-- Thay đổi action để phù hợp với controller -->
        <div class="form-group">
            <label for="name">Họ và Tên:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="address">Địa chỉ:</label>
            <input type="text" class="form-control" id="address" name="address" required>
        </div>
        <div class="form-group">
            <label for="phone">Số điện thoại:</label>
            <input type="tel" class="form-control" id="phone" name="phone" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="userName">Tên đăng nhập:</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Đăng Ký</button>
        <p class="mt-3">Đã có tài khoản? <a href="/auth?action=login">Đăng Nhập</a></p>
    </form>
</div>
<!-- Footer -->
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