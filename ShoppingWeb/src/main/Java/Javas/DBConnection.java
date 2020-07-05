package Javas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/** Some code from hw3 and with little changes */
public class DBConnection {

    /** data base information, all you need is here :)) */
    public static String TABLE_NAME = "products";
    public static String USERNAME = "root", DB_SERVER = "localhost", PASSWORD = "coachelo"; // coachella ;ddd
    public static String MY_DB_NAME = "new_schema", FILE_NAME = "products.sql";

    private Connection conn;

    public DBConnection() throws SQLException, ClassNotFoundException, IOException {
        setConnection();
        addDataBase();
    }

    /* returns connection */
    public Connection getConnection(){
        return conn;
    }

    /* closes connection */
    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /* adds new database */
    private void addDataBase() throws SQLException, IOException {
        try {
            Statement statement = conn.createStatement();
            statement.execute("USE " + MY_DB_NAME);
        } catch (SQLException e) {
            recreateDataBase();
            readFile();
        }
    }

    /*  Creates sql-database-metropolis */
    public void recreateDataBase() throws SQLException {
        Statement stm = conn.createStatement();
        stm.execute(dropDataBaseSQLStatement());
        stm.execute("CREATE DATABASE " + MY_DB_NAME);
        stm.execute("USE " + MY_DB_NAME);
        stm.execute(dropTableSQLStatement());
        stm.execute(createTableSQLStatement());
    }

    /* Returns only a SQL statement */
    private String dropDataBaseSQLStatement() {
        return "DROP DATABASE IF EXISTS " + MY_DB_NAME;
    }

    /* Returns only a SQL statement */
    private String dropTableSQLStatement() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /* returns sql-statement which creates table */
    private String createTableSQLStatement() {
        return "CREATE TABLE " + TABLE_NAME + "("
                   + " productid CHAR(6), name CHAR(64),"
                   + " imagefile CHAR(64), price DECIMAL(6,2) );" ;
    }

    /* Initialize connection between sql-base and brain */
    public void setConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://" + DB_SERVER + "/?useUnicode=true&useJDBC" +
                        "CompliantTimezoneShift=true" +
                        "&useLegacyDatetimeCode=false&serverTimezone=UTC",
                USERNAME, PASSWORD);
    }

    // It's code of reading SQL code and running it from here.
    private void readFile() throws IOException, SQLException {
        Statement statement = conn.createStatement();
        BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME));
        String line = "";
        while (true){
            String curr = bf.readLine();
            if (curr == null) break;
            line += curr;
            if (line.contains(";")) {
                statement.execute(line);
                line = "";
            }
        }
    }
}
