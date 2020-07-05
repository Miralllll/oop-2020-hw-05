package Servlets;

import Javas.Account;
import Javas.AccountManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginSV", urlPatterns = "")
public class Login extends HttpServlet {

    @Override // checks if account exists, if yes - welcome page, if no - try again page to log in
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountManager acm = (AccountManager)getServletContext().getAttribute(AccountManager.NAME);
        Account acc = new Account(request.getParameter("name"), request.getParameter("password"));
        String resultFl = "/WEB-INF/loginFailed.jsp";
        if(acm.containsUser(acc)) resultFl = "/WEB-INF/loginSucceeded.jsp";
        RequestDispatcher reqD = request.getRequestDispatcher(resultFl);
        reqD.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher reqD = request.getRequestDispatcher( "/WEB-INF/login.jsp");
        reqD.forward(request, response);
    }
}
