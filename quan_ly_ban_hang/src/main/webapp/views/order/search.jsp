
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Bán Hàng Điện Máy</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://boostrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://datatables/css/datatables.bootstrap5.min.css"/>
    <style>

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

        /* Hiển thị menu dropdown khi hover */
        .btn-group:hover .dropdown-menu {
            display: block;
        }

        /* Định dạng menu dropdown */
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


        /* Hiển thị menu dropdown khi hover */
        .btn-group:hover .dropdown-menu {
            display: block;
        }

        /* Định dạng menu dropdown */
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
        /* Custom Pagination Styling */
        .dataTables_wrapper .dataTables_paginate .paginate_button {
            padding: 5px 10px;
            margin: 2px;
            color: #007bff !important;
            border: 1px solid #007bff;
            border-radius: 4px;
            transition: background-color 0.3s, color 0.3s;
        }

        .dataTables_wrapper .dataTables_paginate .paginate_button.current {
            background-color: #007bff;
            color: white !important;
        }

        .dataTables_wrapper .dataTables_paginate .paginate_button:hover {
            background-color: #0056b3;
            color: white !important;
            border-color: #0056b3;
        }

        /* Styling the text */
        .dataTables_info {
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
<div class="container min-vh-100">
    <h3 class="mb-4">THÔNG TIN ORDER</h3>

    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Tên Khách Hàng</th>
            <th>Ngày Đặt Hàng</th>
            <th>Trạng Thái</th>
            <th>Chi Tiết</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderDTO}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.nameCustomer}</td>
                <td>${order.date}</td>
                <td>${order.status}</td>
                <td><a href="/order?action=orderDetail&id=${order.id}" class="btn btn-info btn-sm">Chi Tiết</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.boostrap5.min.js"></script>
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