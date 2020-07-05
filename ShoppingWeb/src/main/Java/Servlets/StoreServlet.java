package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Store", urlPatterns = "/")
public class StoreServlet extends HttpServlet {
    @Override // opens start page
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher reqD = request.getRequestDispatcher("/WEB-INF/product-list.jsp");
        reqD.forward(request, response);
    }
}
