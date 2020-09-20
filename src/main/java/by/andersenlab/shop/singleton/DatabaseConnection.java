package by.andersenlab.shop.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static volatile Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseConnection.class) {
                if (connection == null) {
                    createConnection();
                }
            }
        }
        return connection;
    }

    private static void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
