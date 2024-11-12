package org.yourcompany.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/DataBaseIanKonter";
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

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Failed to close the database connection.");
                e.printStackTrace();
            }
        }
    }

    public void checkAndCreateDatabaseAndTables(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            // Cek apakah database sudah ada
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS DataBaseIanKonter");
            System.out.println("Database checked/created.");

            // Menggunakan database
            statement.executeUpdate("USE DataBaseIanKonter");

            // Cek dan buat tabel idpelanggan
            String createPelangganTable = "CREATE TABLE IF NOT EXISTS idpelanggan (" +
                    "IDMeteran BIGINT(20) NOT NULL, " +
                    "NamaPelanggan VARCHAR(255) NOT NULL" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";
            statement.executeUpdate(createPelangganTable);
            System.out.println("Table 'idpelanggan' checked/created.");

            // Cek dan buat tabel riwayattransaksi
            String createRiwayatTransaksiTable = "CREATE TABLE IF NOT EXISTS riwayattransaksi (" +
                    "NO INT(11) NOT NULL, " +
                    "IDPELANGGAN BIGINT(20) NOT NULL, " +
                    "PAKET VARCHAR(25) NOT NULL, " +
                    "PROMO VARCHAR(25) NOT NULL, " +
                    "TOTALHARGA VARCHAR(27) NOT NULL, " +
                    "STATUS VARCHAR(10) NOT NULL, " +
                    "TANGGAL VARCHAR(24) NOT NULL" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";
            statement.executeUpdate(createRiwayatTransaksiTable);
            System.out.println("Table 'riwayattransaksi' checked/created.");

        } catch (SQLException e) {
            System.out.println("Error while checking/creating database and tables.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MySQLConnector connector = new MySQLConnector(); // Membuat instance dari MySQLConnector
        Connection connection = connector.connect(); // Memanggil metode connect
        if (connection != null) {
            connector.checkAndCreateDatabaseAndTables(connection); // Memanggil metode untuk cek dan buat database serta tabel
            connector.closeConnection(connection); // Menutup koneksi
        }
    }
}