<%@ page import="org.example.quan_ly_ban_hang.dto.CustomerPurchaseDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.quan_ly_ban_hang.model.Customer" %>
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

<!-- Form tìm kiếm khách hàng -->
<form action="customer" method="get" class="form-inline mb-4">
    <input type="text" name="name" class="form-control mx-sm-2" placeholder="Tìm theo tên khách hàng" value="${param.name}">
    <input type="hidden" name="action" value="search">
    <button type="submit" class="btn btn-primary">Tìm kiếm</button>
</form>

<!-- Button xem khách hàng mua nhiều nhất -->
<form action="customer" method="get" class="form-inline mb-4">
    <input type="hidden" name="action" value="topCustomers">
    <button type="submit" class="btn btn-success">Khách hàng mua nhiều nhất</button>
</form>

<%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
    if (customers != null && !customers.isEmpty()) {
%>
<table class="table table-bordered">
    <thead class="thead-light">
    <tr>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Customer customer : customers) {
    %>
    <tr>
        <td><%= customer.getName() %></td>
        <td><%= customer.getEmail() %></td>
        <td><%= customer.getAddress() %></td>
        <td><%= customer.getPhone() %></td>
        <td>
            <form action="customer" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<%= customer.getId() %>">
                <input type="hidden" name="action" value="delete">
                <button type="submit" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa khách hàng này?')">Xóa</button>
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<% } else { %>
<div class="alert alert-warning">Không có khách hàng nào trong danh sách.</div>
<% } %>

<% if (request.getAttribute("message") != null) { %>
<div class="alert alert-danger"><%= request.getAttribute("message") %></div>
<% } %>

<!-- Phần phân trang -->
<nav>
    <ul class="pagination">
        <%
            Integer currentPage = (Integer) request.getAttribute("currentPage");
            Integer totalPages = (Integer) request.getAttribute("totalPages");

            if (currentPage == null) {
                currentPage = 1;
            }
            if (totalPages == null) {
                totalPages = 1;
            }

            if (currentPage > 1) {
        %>
        <li class="page-item"><a class="page-link" href="customer?page=<%= currentPage - 1 %>">Trước</a></li>
        <%
            }

            for (int i = 1; i <= totalPages; i++) {
                if (i == currentPage) {
        %>
        <li class="page-item active"><span class="page-link"><%= i %></span></li>
        <%
        } else {
        %>
        <li class="page-item"><a class="page-link" href="customer?page=<%= i %>"><%= i %></a></li>
        <%
                }
            }

            if (currentPage < totalPages) {
        %>
        <li class="page-item"><a class="page-link" href="customer?page=<%= currentPage + 1 %>">Sau</a></li>
        <%
            }
        %>
    </ul>
</nav>

<!-- Phần hiển thị khách hàng mua nhiều nhất -->
<% if (request.getAttribute("topCustomers") != null) { %>
<h2 class="mt-5">Khách hàng mua nhiều nhất</h2>
<table class="table table-bordered">
    <thead class="thead-light">
    <tr>
        <th>Họ tên</th>
        <th>Số lượng sản phẩm đã mua</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<CustomerPurchaseDTO> topCustomers = (List<CustomerPurchaseDTO>) request.getAttribute("topCustomers");
        for (CustomerPurchaseDTO customer : topCustomers) {
    %>
    <tr>
        <td><%= customer.getCustomerName() %></td>
        <td><%= customer.getProductCount() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
<a href="products" class="btn btn-primary">Quay lại danh sách sản phẩm</a>
<% } %>

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
