<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm</title>
    <!-- Bootstrap CSS via CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center">Kết quả tìm kiếm cho từ khóa: "<c:out value="${param.keyword}" />"</h1>

    <!-- Kiểm tra nếu có kết quả tìm kiếm -->
    <c:choose>
        <c:when test="${not empty product}">
            <div class="table-responsive">
                <table class="table table-bordered table-striped mt-3">
                    <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Mô Tả</th>
                        <th>Giá</th>
                        <th>Hình Ảnh</th>
                        <th>Sửa</th>
                        <th>Xóa</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${product}">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.productName}</td>
                            <td>${product.description}</td>
                            <td><fmt:formatNumber value="${product.price}" type="currency" currencySymbol="VND"/></td>
                            <td><img src="${product.image}" alt="${product.productName}" width="100"></td>
                            <td>
                                <a href="/products?action=edit&id=${product.id}" class="btn btn-sm btn-warning">Sửa</a>
                            </td>
                            <td>
                                <a href="/products?action=delete&id=${product.id}" class="btn btn-sm btn-danger" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?')">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-warning mt-3" role="alert">
                Không tìm thấy sản phẩm nào.
            </div>
        </c:otherwise>
    </c:choose>

    <div class="mt-3">
        <a href="/products?action=list" class="btn btn-secondary">Quay lại danh sách sản phẩm</a>
    </div>
</div>

<!-- Bootstrap JS and dependencies via CDN -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>