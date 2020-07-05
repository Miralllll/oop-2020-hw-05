<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome to Homework 5</h1>
<p>Please log in.</p>
<%-- Here is a form. If an user clicks to the Login button Login class
     (Servlet class) - doPost will check what brouser should do next --%>
<form action="" method="post">
    <label for="name">User Name:</label>
    <input type="text" id="name" name="name">
    <br>
    <br>
    <label for="password">Password:</label>
    <input type="text" id="password" name="password">
    <input type="submit" value="Login">
</form>
<br>
<a href="/CreateAccount">Create New Account</a>
</body>
</html>