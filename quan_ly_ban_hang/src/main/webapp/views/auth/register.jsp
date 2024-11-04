<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng Ký Tài Khoản</title>
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
<header class="bg-primary text-white">
  <div class="container d-flex justify-content-between align-items-center py-3">
    <h1 class="h4">Điện Máy XYZ</h1>
    <nav class="nav">
      <a class="nav-link text-white" href="#search">Tìm Kiếm</a>
      <a class="nav-link text-white" href="#about">Giới Thiệu</a>
      <a class="nav-link text-white" href="#products">Sản Phẩm</a>
      <a class="nav-link text-white" href="#contact">Liên Hệ</a>
      <a class="nav-link text-white" href="#cart">Giỏ Hàng</a>
      <c:if test="${sessionScope.account != null}">
        <a class="nav-link text-white" href="#admin">Admin</a>
      </c:if>
    </nav>
    <c:choose>
      <c:when test="${sessionScope.account == null}">
        <div class="btn-group">
          <a class="btn btn-light" href="/auth?action=login">Đăng Nhập</a>
          <a class="btn btn-light" href="/auth?action=register">Đăng Ký</a>
        </div>
      </c:when>
      <c:otherwise>
        <div class="btn-group">
          <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              ${sessionScope.account.name}
          </button>
          <div class="dropdown-menu dropdown-menu-right">
            <a class="dropdown-item" href="/auth?action=profile">Thông Tin Tài Khoản</a>
            <a class="dropdown-item" href="/auth?action=logout">Đăng Xuất</a>
          </div>
        </div>
      </c:otherwise>
    </c:choose>
  </div>
</header>
<div class="container">
  <h2 class="text-center">Đăng Ký Tài Khoản</h2>

  <c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
  </c:if>

  <form action="/auth?action=register" method="post">
    <div class="form-group">
      <label for="username">Tên Đăng Nhập:</label>
      <input type="text" class="form-control" id="username" name="username" required>
    </div>
    <div class="form-group">
      <label for="password">Mật Khẩu:</label>
      <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <div class="form-group">
      <label for="name">Tên:</label>
      <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="form-group">
      <label for="address">Địa Chỉ:</label>
      <input type="text" class="form-control" id="address" name="address" required>
    </div>
    <div class="form-group">
      <label for="phone">Số Điện Thoại:</label>
      <input type="text" class="form-control" id="phone" name="phone" required>
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <button type="submit" class="btn btn-primary">Đăng Ký</button>
  </form>
  <p class="mt-3 text-center">Đã có tài khoản? <a href="/auth?action=login">Đăng Nhập</a></p>
</div>
<!-- footer -->
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