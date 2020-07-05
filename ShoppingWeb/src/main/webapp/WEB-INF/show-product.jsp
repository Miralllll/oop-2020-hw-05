<%@ page import="Javas.ProductCatalog" %>
<%@ page import="Javas.Product" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%
        // gets product id and then product itself
        ProductCatalog cat = (ProductCatalog) application.getAttribute(ProductCatalog.NAME);
        Product product = cat.getProduct(request.getParameter("id"));
    %>
    <title><%= product.getName()%></title>
</head>
<body>
<h1><%= product.getName()%></h1>

<img src="<%= "/store-images/" + product.getImageFile()%>"
     alt="<%= product.getName()%>">
<form action="/Product" method="post">
    <label>$<%= Float.toString(product.getPrice())%></label>
    <input name="productId" type="hidden" value="<%= product.getProductId()%>">
    <input type="submit" value="Add to Cart">
</form>
</body>
</html>
