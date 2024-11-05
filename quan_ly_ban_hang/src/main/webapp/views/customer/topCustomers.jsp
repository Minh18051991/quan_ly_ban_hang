<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Điện Máy XYZ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            min-height: 100vh;
            color: white;
            filter: brightness(0.8);
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }
        header {
            z-index: 1;
        }
        .nav {
            margin-right: auto;
        }
        footer {
            background-color: #343a40;
            color: white;
        }
        .btn-group:hover .dropdown-menu {
            display: block;
        }
        .dropdown-menu {
            background-color: #343a40;
            border: none;
            border-radius: 0;
            padding: 0.5rem 0;
        }
        .dropdown-item {
            color: #fff;
            padding: 0.5rem 1rem;
        }
        .dropdown-item:hover, .dropdown-item:focus {
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
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
            <a class="nav-link text-white" href="/customer">xem khách hàng</a>

            <c:if test="${sessionScope.account != null && sessionScope.role == 'admin'}">
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
                            ${sessionScope.account.username}
                    </button>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="/auth?action=update">Thông Tin Tài Khoản</a>
                        <a class="dropdown-item" href="/auth?action=logout">Đăng Xuất</a>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</header>

<c:if test="${not empty topCustomers}">
    <div class="container mt-4">
        <table id="tableTopCustomers" class="table table-bordered">
            <thead>
            <tr>
                <th>ID Khách Hàng</th>
                <th>Tên Khách Hàng</th>
                <th>Số Lượng Sản Phẩm</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="topCustomer" items="${topCustomers}">
                <tr>
                    <td>${topCustomer.customerId}</td>
                    <td>${topCustomer.customerName}</td>
                    <td>${topCustomer.productCount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!-- Thêm nút Quay lại trang danh sách khách hàng -->
        <a href="customer" class="btn btn-primary">Quay lại danh sách khách hàng</a>
    </div>
</c:if>

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
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableTopCustomers').DataTable();
    });
</script>
</body>
</html>
