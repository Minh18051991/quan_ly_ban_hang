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
            <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
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
    <h3>DANH SÁCH ORDER</h3>
    <form action="/order?action=searchByName" method="post" class="form-inline mb-3">
        <input type="text" name="name" class="form-control mr-2" placeholder="Nhập tên khách hàng">
        <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
    </form>
    <table id="tableStudent" class="table table-striped table-bordered" style="width: 100%">
        <thead>
        <tr>
            <th>Mã Order</th>
            <th>Người Đặt Hàng</th>
            <th>Ngày Tạo</th>
            <th>Trạng Thái</th>
            <th>Xóa</th>
            <th>Chi Tiết</th>
            <th>Phê Duyệt</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOrder}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.nameCustomer}</td>
                <td>${order.date}</td>
                <td>${order.status}</td>
                <td><a href="/order?action=delete&id=${order.id}" class="btn btn-danger btn-sm">Xóa</a></td>
                <td><a href="/order?action=orderDetail&id=${order.id}" class="btn btn-info btn-sm">Chi Tiết</a></td>
                <td><a href="/order?action=approve&id=${order.id}" class="btn btn-success btn-sm">Phê Duyệt</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center py-3">
    <p class="mb-0">&copy; 2023 Điện Máy XYZ. Tất cả quyền được bảo lưu.</p>
    <p>Liên hệ: support@dienmayxyz.com | Số điện thoại: 0123-456-789</p>
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