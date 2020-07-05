package Javas;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** ContextListener - creates new account manager */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext cont = servletContextEvent.getServletContext();
        cont.setAttribute(AccountManager.NAME, new AccountManager());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
