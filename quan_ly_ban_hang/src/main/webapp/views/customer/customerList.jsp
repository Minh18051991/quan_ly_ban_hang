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

<div class="container mt-5">
    <h2>Danh Sách Khách Hàng</h2>
    <form method="get" action="" class="mb-3">
        <input type="hidden" name="action" value="search">
        <div class="form-group">
            <input type="text" name="name" class="form-control" placeholder="Nhập tên khách hàng">
        </div>
        <button type="submit" class="btn btn-primary">Tìm kiếm</button>
    </form>

    <c:if test="${not empty message}">
        <div class="alert alert-info mt-3">${message}</div>
    </c:if>

    <table id="customerTable" class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Địa chỉ</th>
            <th>Điện thoại</th>
            <th>Email</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>
                <td>
                    <form method="post" action="" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${customer.id}">
                        <button type="submit" class="btn btn-danger">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <c:if test="${currentPage > 1}">
                <li class="page-item">
                    <a class="page-link" href="?page=${currentPage - 1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${totalPages}" var="i">
                <li class="page-item <c:if test="${i == currentPage}">active</c:if>">
                    <a class="page-link" href="?page=${i}">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${currentPage < totalPages}">
                <li class="page-item">
                    <a class="page-link" href="?page=${currentPage + 1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>

    <h3 class="mt-5">Người Mua Nhiều Nhất</h3>
    <a href="?action=topCustomers" class="btn btn-success mb-3">Xem Top Khách Hàng</a>

    <c:if test="${not empty topCustomers}">
        <table id="tableTopCustomers" class="table table-bordered mt-3">
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
    </c:if>
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
<script src="datatables/js/jquery.dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#customerTable').DataTable();
    });
</script>
</body>
</html>
