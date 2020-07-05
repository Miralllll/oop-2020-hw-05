<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Information Incorrect</title>
</head>
<body>
<%-- Its all about try again text ;ddd --%>
<h1>Please Try Again</h1>
<p>Either your user name or password is incorrect. Please try again.</p>
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