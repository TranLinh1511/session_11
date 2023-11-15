package com.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class ConnectionDB {
    private static final String DRIVER_JDBC = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/product_management";
    private static final String USER = "root";
    private static final String PASSWORD = "Aa151120";

    public static Connection openConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_JDBC);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi 1");
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null ) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Lỗi 2");
            }
        }
    }
}
