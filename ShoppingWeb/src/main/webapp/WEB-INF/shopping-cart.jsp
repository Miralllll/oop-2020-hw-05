<%@ page import="Javas.ShoppingCart" %>
<%@ page import="Javas.ProductCatalog" %>
<%@ page import="java.util.List" %>
<%@ page import="Javas.Product" %>
<%@ page import="java.util.Set" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shopping Cart</title>
</head>
<body>
<h1>Shopping Cart</h1>
<%
    // gets catalog and cart here and produces the list of products
    ShoppingCart cart = (ShoppingCart) session.getAttribute(ShoppingCart.NAME);
    ProductCatalog cat = (ProductCatalog) application.getAttribute(ProductCatalog.NAME);
    Set<String> productIds = cart.getProducts();
    List<Product> products = cat.getProducts(productIds);
%>
<form action="/ShoppingCart" method="post">
    <%
        float sum = 0; // iterates the products
        for(Product product : products) {
            sum += product.getPrice() * cart.getAmount(product.getProductId());
            out.print("<li> <input type ='number' value='" + cart.getAmount(product.getProductId())
                    + "' name='" + product.getProductId() + "'> " + product.getName() + ", "
                    + product.getPrice() + "</li>");
        }
    %>
    <br>
    <label>Total: $<%= sum%></label>
    <input type="submit" value="Update Cart">
</form>
<br>
<a href="/">Continue Shopping</a>
</body>
</html>