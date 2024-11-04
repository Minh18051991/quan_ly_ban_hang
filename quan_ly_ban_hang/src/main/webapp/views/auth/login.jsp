<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="path/to/your/styles.css"> <!-- Thay đổi đường dẫn nếu cần -->
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <form action="auth" method="post">
        <input type="hidden" name="action" value="login">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>
    <p>Don't have an account? <a href="auth?action=register">Register here</a></p>
</div>
</body>
</html>