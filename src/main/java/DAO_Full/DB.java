package DAO_Full;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static String url = "jdbc:mysql://localhost:3308/employee";
    private static String user = "root";
    private static String password = "root";

    public DB() {
    }

    public static Connection getConnection() {
        try {
            Connection connection = null;
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
