package org.yourcompany.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    // Method untuk menghubungkan ke database
    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("Connection to MySQL database established!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to MySQL database failed.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        MySQLConnector connector = new MySQLConnector(); // Membuat instance dari MySQLConnector
        Connection connection = connector.connect(); // Memanggil metode connect
    }
}
