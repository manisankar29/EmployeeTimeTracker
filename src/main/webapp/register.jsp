<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Register</h2>
    <form action="user?action=register" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="employeeId">Employee ID:</label>
        <input type="text" id="employeeId" name="employeeId" required><br>

        <label for="idProof">ID Proof:</label>
        <input type="text" id="idProof" name="idProof" required><br>

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="role">Role:</label>
        <input type="text" id="role" name="role" required><br>

        <input type="submit" value="Register">
    </form>
    <a href="login.jsp">Login</a>
</body>
</html>
