package Javas;
import Javas.ProductCatalog;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.sql.SQLException;

/** It is a webListener.-- creates new catalog from the sql database */
@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ProductCatalog catalog = null;
        try {
            catalog = new ProductCatalog();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ServletContext cont = servletContextEvent.getServletContext();
        cont.setAttribute(ProductCatalog.NAME, catalog);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
