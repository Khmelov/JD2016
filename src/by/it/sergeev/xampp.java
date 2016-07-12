package by.it.sergeev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class xampp {


    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {

        final String URL2016 = "jdbc:mysql://127.0.0.1:2016/sergeev"
         + "?useUnicode=true&characterEncoding=UTF-8";
        return getConnection(URL2016, USER, PASSWORD);
    }

    public static Connection getConnection(int port) throws SQLException {
        final String URL = "jdbc:mysql://127.0.0.1:" + port + "/sergeev"
         + "?useUnicode=true&characterEncoding=UTF-8";
        return getConnection(URL, USER, PASSWORD);
    }

    public static Connection getConnection(String URL, String USER, String PASSWORD) throws SQLException {

        return DriverManager.getConnection
                (URL, USER, PASSWORD);
    }

}