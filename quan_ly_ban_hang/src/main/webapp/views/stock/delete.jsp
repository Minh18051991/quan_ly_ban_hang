<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/4/2024
  Time: 1:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Stock</title>
</head>
<body>
<h1>Delete Stock</h1>
<p>Enter the Stock ID you wish to delete:</p>
<form action="/stock" method="post">
    <input type="hidden" name="action" value="delete">
    <label>Stock ID:</label>
    <input type="number" name="id" required>
    <br>
    <input type="submit" value="Delete Stock">
</form>
<a href="/stock">Back to Stock List</a>
</body>
</html>

