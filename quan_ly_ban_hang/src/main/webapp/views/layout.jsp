<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Bán Hàng Điện Máy</title>
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

        .header-content {
            display: flex;
            justify-content: space-between; /* Tách biệt phần trái và phải */
            align-items: center; /* Căn giữa theo chiều dọc */
        }

        .nav {
            margin-right: auto; /* Đẩy các phần bên trái về phía trái */
        }

        .login-buttons {
            margin-left: 20px; /* Khoảng cách giữa menu và nút đăng nhập */
        }

        footer {
            background-color: #343a40; /* Màu nền của footer */
            color: white; /* Màu chữ trong footer */
        }

        .login-buttons {
            position: absolute; /* Đưa các nút về phía bên phải */
            right: 10px; /* Căn sát phải */
        }

    </style>
</head>
<body>

<!-- Header -->
<header class="bg-primary text-white">
    <div class="container header-content py-3">
        <div class="d-flex align-items-left">
            <h1 class="h4 mb-0">Điện Máy XYZ</h1>
            <nav class="nav ml-3">
                <a class="nav-link text-white" href="#search">Tìm Kiếm</a>
                <a class="nav-link text-white" href="#about">Giới Thiệu</a>
                <a class="nav-link text-white" href="#products">Sản Phẩm</a>
                <a class="nav-link text-white" href="#contact">Liên Hệ</a>
                <a class="nav-link text-white" href="#cart">Giỏ Hàng</a>
                <a class="nav-link text-white" href="#admin">Admin</a>

            </nav>
        </div>
        <div class="login-buttons">
            <a href="/auth?action=login" class="btn btn-light">
                <i class="fa fa-user"></i> Đăng Nhập
            </a>
            <a href="/auth?action=register" class="btn btn-light">
                <i class="fa fa-user-plus"></i> Đăng Ký
            </a>
        </div>
    </div>
</header>

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