<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Account</title>
</head>
<body>
<h1>The Name <%= request.getParameter("name")%> is Already In Use</h1>
<p>Please enter another name and password.</p>
<%-- Here is a form. If an user clicks to the Login button AccountCreation class
     (Servlet class) - spesificly doPost, will check what brouser should do next --%>
<form action="/CreateAccount" method="post">
    <label for="name">User Name:</label>
    <input type="text" id="name" name="name">
    <br> <br>
    <label for="password">Password:</label>
    <input type="text" id="password" name="password">
    <input type="submit" value="Login">
</form>
</body>
</html>