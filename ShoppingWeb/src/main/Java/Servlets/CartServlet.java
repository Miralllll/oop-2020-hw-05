package Servlets;

import Javas.ShoppingCart;
import org.graalvm.compiler.nodes.calc.ObjectEqualsNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ShoppingCart", urlPatterns = "/ShoppingCart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession hSession = request.getSession();
        ShoppingCart spCart = (ShoppingCart)hSession.getAttribute(ShoppingCart.NAME);
        Enumeration<String> params = request.getParameterNames();
        ShoppingCart cartForNewUser = new ShoppingCart();
        while(params.hasMoreElements()){
            String currProductId = params.nextElement();
            String param = request.getParameter(currProductId);
            if(param != "" && Long.parseLong(param) > 0)
                cartForNewUser.addProduct(currProductId,  Long.parseLong(param));
        }
        spCart = cartForNewUser;
        hSession.setAttribute(ShoppingCart.NAME, spCart);
        response.sendRedirect("/ShoppingCart");
        //RequestDispatcher reqD = request.getRequestDispatcher("/WEB-INF/shopping-cart.jsp");
        //reqD.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession hSession = request.getSession();
        ShoppingCart spCart = (ShoppingCart)hSession.getAttribute(ShoppingCart.NAME);
        System.out.println("here i am");
        System.out.println(spCart.getProducts().size());
        hSession.setAttribute(ShoppingCart.NAME, spCart);
        RequestDispatcher reqD = request.getRequestDispatcher("/WEB-INF/shopping-cart.jsp");
        reqD.forward(request, response);
    }
}
