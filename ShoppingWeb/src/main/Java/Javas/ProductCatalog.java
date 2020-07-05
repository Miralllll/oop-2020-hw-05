package Javas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** Uses connection and gets information from it */
public class ProductCatalog {

    private DBConnection dbCon;
    private Connection conn;

    public ProductCatalog() throws SQLException, IOException, ClassNotFoundException {
        dbCon = new DBConnection();
        conn = dbCon.getConnection();
    }

    /* closes connection which is currently open */
    public void closeCatalog(){
        dbCon.closeConnection();
    }

    /* gets product information from database with products id */
    public Product getProduct(String productId) throws SQLException {
        String sqlSt = SELECT_SQL + " WHERE productid = " + "'" +  productId + "'";
        return getProductsWith(sqlSt).get(0);
    }

    /* returns a current list of products from database */
    public List<Product> getProducts() throws SQLException {
        return getProductsWith(SELECT_SQL);
    }

    /* returns a current list of products from database by searching with its productIds */
    public List<Product> getProducts(Set<String> productIds) throws SQLException {
        if(productIds.isEmpty()) return new ArrayList<Product>();
        String sqlSt = SELECT_SQL + " WHERE ";
        for(String productId : productIds)
            sqlSt += " productid = '" + productId + "'" + " OR";
        sqlSt = sqlSt.substring(0, sqlSt.length() - 3) + ";";
        return getProductsWith(sqlSt);
    }

    /* gets some sql code and use it for getting information from database */
    private List<Product> getProductsWith(String sqlSt) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(sqlSt);
        ResultSet res = statement.executeQuery();
        List<Product> ls = new ArrayList<>();
        while (res.next())
            ls.add(new Product(res.getString(1), res.getString(2),
                    res.getString(3), res.getFloat(4)));
        return ls;
    }

    public static final String NAME = "catalog";
    public static final String SELECT_SQL = "SELECT * FROM " + DBConnection.TABLE_NAME;
}
