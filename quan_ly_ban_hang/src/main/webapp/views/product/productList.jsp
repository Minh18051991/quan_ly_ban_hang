<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Sản Phẩm - Điện Máy XYZ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/datatables.bootstrap5.min.css"/>
    <style>
        .sidebar {
            background-color: #f8f9fa;
            padding: 20px;
            border-right: 1px solid #dee2e6;
        }
    </style>
</head>
<body>

<!-- Header -->
<header class="bg-primary text-white">
    <div class="container d-flex justify-content-between align-items-center py-3">
        <h1 class="h4">Điện Máy XYZ</h1>
        <nav class="nav">
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
<div class="container mt-4 d-flex">
    <div class="main-content flex-fill">
        <h2>Danh Sách Sản Phẩm</h2>

        <!-- Form Tìm Kiếm -->
        <form action="/products" method="get" class="mb-3">
            <div class="input-group">
                <input hidden="hidden" type="text" name="action" class="form-control" value="search" aria-label="Tìm kiếm sản phẩm">
                <input type="text" name="keyword" class="form-control" placeholder="Tìm kiếm sản phẩm..." aria-label="Tìm kiếm sản phẩm">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit">Tìm Kiếm</button>
                </div>
            </div>
        </form>

        <a href="/products?action=addForm" class="btn btn-primary mb-3">Thêm Sản Phẩm Mới</a>
        <table id="tableStudent" class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Tên Sản Phẩm</th>
                <th>Mô Tả</th>
                <th>Giá</th>
                <th>Hình Ảnh</th>
                <th>Sửa</th>
                <th>Xoá</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.description}</td>
                    <td><fmt:formatNumber value="${product.price}" type="currency" currencySymbol="VND"/></td>
                    <td><img src="${product.image}" alt="${product.productName}" width="100"></td>
                    <td>
                        <a href="/products?action=edit&id=${product.id}" class="btn btn-sm btn-warning"> Sửa</a>
                    </td>
                    <td>
                        <a href="/products?action=delete&id=${product.id}" class="btn btn-sm btn-danger" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center py-3">
    <p class="mb-0">&copy; 2023 Điện Máy XYZ. Tất cả quyền được bảo lưu.</p>
    <p>Liên hệ: support@dienmayxyz.com | Số điện thoại: 0123-456-789</p>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap5.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tableStudent').DataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
