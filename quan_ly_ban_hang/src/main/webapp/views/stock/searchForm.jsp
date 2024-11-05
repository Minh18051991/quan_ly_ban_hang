<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/4/2024
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Tìm kiếm sản phẩm trong kho</title>
</head>
<body>
<h1>Tìm sản phẩm theo id</h1>
<form action="/stock?action=searchForm" method="get">
    <input type="hidden" name="action" value="search">
    <label>Product ID:</label>
    <input type="number" name="product_id">
    <br>
    <label>Quantity:</label>
    <input type="number" name="quantity">
    <br>
    <input type="submit" value="Search">
</form>
<a href="/stock">Quay lại Danh sách sản phẩm trong kho</a>
</body>
</html>
