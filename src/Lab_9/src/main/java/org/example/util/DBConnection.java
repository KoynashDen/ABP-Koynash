package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection connection;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        loadProperties();
    }

    private DBConnection() {}

    private static void loadProperties() {
        try (InputStream input = DBConnection.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            Properties props = new Properties();
            if (input == null) {
                throw new IOException("⚠️ Cannot find application.properties");
            }

            props.load(input);
            URL = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");

        } catch (IOException e) {
            System.err.println("❌ Failed to load DB config: " + e.getMessage());
        }
    }

    private static void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("🔌 Connected to DB");
        } catch (SQLException e) {
            System.err.println("❌ DB Connection error: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                System.out.println("ℹ️ Connecting to DB...");
                connect();
            }
        } catch (SQLException e) {
            System.err.println("❌ Connection check failed: " + e.getMessage());
            connect();
        }

        return connection;
    }
}
