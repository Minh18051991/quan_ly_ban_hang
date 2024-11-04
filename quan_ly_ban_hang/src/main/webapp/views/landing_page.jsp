<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Bán Hàng Điện Máy</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom styles */
        .banner {
            background-image: url('#');
            background-size: cover;
            background-position: center;
            height: 400px;
            color: white;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
        .featured-products, .news-promotions {
            padding: 50px 0;
        }
        .featured-products h2, .news-promotions h2 {
            font-size: 2rem;
            font-weight: bold;
        }
    </style>
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
        <!-- Đăng Nhập/Đăng Xuất -->
        <div>
            <a href="/views/login.jsp" class="btn btn-light">
                <i class="fa fa-user"></i> Đăng Nhập
            </a>
        </div>
    </div>
</header>

<!-- Banner -->
<section class="banner">
    <div class="container">
        <h2>Chào Mừng Đến Với Cửa Hàng Điện Máy XYZ</h2>
        <p>Cung cấp các sản phẩm điện máy chất lượng, giá tốt nhất</p>
        <a href="#products" class="btn btn-warning mt-3">Khám Phá Ngay</a>
    </div>
</section>

<!-- Featured Products -->
<section class="featured-products">
    <div class="container">
        <h2 class="text-center">Sản Phẩm Nổi Bật</h2>
        <div class="row">
            <c:forEach var="product" items="${featuredProducts}">
                <div class="col-md-3">
                    <div class="card mb-4 shadow-sm">
                        <img src="${product.imageUrl}" class="card-img-top" alt="${product.name}">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.description}</p>
                            <a href="${product.link}" class="btn btn-primary">Xem Chi Tiết</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<!-- News and Promotions -->
<section class="news-promotions bg-light">
    <div class="container">
        <h2 class="text-center">Tin Tức & Khuyến Mãi</h2>
        <div class="row">
            <c:forEach var="news" items="${newsList}">
                <div class="col-md-4">
                    <div class="card mb-4">
                        <img src="${news.imageUrl}" class="card-img-top" alt="${news.title}">
                        <div class="card-body">
                            <h5 class="card-title">${news.title}</h5>
                            <p class="card-text">${news.summary}</p>
                            <a href="${news.link}" class="btn btn-secondary">Đọc Thêm</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="bg-dark text-white mt-5">
    <div class="container py-4">
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
