<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm</title>
    <link rel="stylesheet" href="path/to/your/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1>Kết quả tìm kiếm cho từ khóa: "<c:out value="${param.keyword}" />"</h1>

    <!-- Kiểm tra nếu có kết quả tìm kiếm -->
    <c:choose>
        <c:when test="${not empty product}">
            <table class="table table-bordered table-striped mt-3">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên sản phẩm</th>
                    <th>Mô tả</th>
                    <th>Giá</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${product}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.productName}</td>
                        <td>${product.description}</td>
                        <td><fmt:formatNumber value="${product.price}" type="currency" currencySymbol="VND"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>Không tìm thấy sản phẩm nào.</p>
        </c:otherwise>
    </c:choose>
    <div class="mt-3">
        <a href="product?action=list" class="btn btn-secondary">Quay lại danh sách sản phẩm</a>
    </div>
</div>
</body>
</html>
