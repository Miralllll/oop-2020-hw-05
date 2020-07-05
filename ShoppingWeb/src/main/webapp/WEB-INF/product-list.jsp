<%@ page import="Javas.ProductCatalog" %>
<%@ page import="Javas.Product" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Store</title>
</head>
<body>

<h1>Students Store</h1>
<p>Items available:</p>
<ul><%
    // gets catalog from here, easy :))) i think
    ProductCatalog cat = (ProductCatalog)application.getAttribute(ProductCatalog.NAME);
    for(Product product : cat.getProducts())
        out.print("<li> <a href=\"Product?id=" + product.getProductId() + "\">"
                + product.getName() + "</a> </li>");
%></ul>

</body>
</html>