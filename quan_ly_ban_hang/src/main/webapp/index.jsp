<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="refresh" content="0; URL='/views/auth/landing_page.jsp'" />

    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a> <br>
<a href="product?action=product-new">hiển thị sản phẩm mơi nhất</a><br>
<a href="product?action=product-list">hiển thị tất cả sản phẩm</a><br>
<a href="product?action=product-purchased">sản phẩm được mua nhiều nhất</a><br>

</body>
</html>