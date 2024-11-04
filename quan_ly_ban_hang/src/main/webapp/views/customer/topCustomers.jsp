<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Top Khách Hàng</title>
</head>
<body>
<div class="container mt-5">
    <h2>Top Khách Hàng</h2>

    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>ID Khách Hàng</th>
            <th>Tên Khách Hàng</th>
            <th>Số Lượng Sản Phẩm</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${topCustomers}">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.customerName}</td>
                <td>${customer.productCount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <c:if test="${currentPage > 1}">
                <li class="page-item">
                    <a class="page-link" href="?action=topCustomers&page=${currentPage - 1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${totalPages}" var="i">
                <li class="page-item <c:if test="${i == currentPage}">active</c:if>">
                    <a class="page-link" href="?action=topCustomers&page=${i}">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${currentPage < totalPages}">
                <li class="page-item">
                    <a class="page-link" href="?action=topCustomers&page=${currentPage + 1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>

    <a href="${pageContext.request.contextPath}/customer" class="btn btn-primary mt-3">Quay Về Trang Chính</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
