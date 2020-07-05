package Servlets;

import Javas.Product;
import Javas.ProductCatalog;
import Javas.ShoppingCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Product", urlPatterns = "/Product")
public class ProductServlet extends HttpServlet {

    @Override // gets cart from session and adds new product
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession hSession = request.getSession();
        ShoppingCart spCart = (ShoppingCart)hSession.getAttribute(ShoppingCart.NAME);
        // if(spCart == null) spCart = new ShoppingCart();
        Object addProductId = request.getParameter("productId");
        spCart.addProduct((String)addProductId, 1);
        hSession.setAttribute(ShoppingCart.NAME, spCart);
        response.sendRedirect("/ShoppingCart");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         RequestDispatcher reqD = request.getRequestDispatcher("/WEB-INF/show-product.jsp");// comment them, its nothing
         reqD.forward(request, response); // comment them, its nothing
    }
}
