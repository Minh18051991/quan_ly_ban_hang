<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <title>Danh Sách Khách Hàng</title>
</head>
<body>
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
