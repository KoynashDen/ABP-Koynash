package org.example.util;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FlywayUtility {

    public static void runMigrations() {
        Properties properties = new Properties();
        try (InputStream input = FlywayUtility.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String url = properties.getProperty("flyway.db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        Flyway flyway = Flyway.configure()
                .defaultSchema("olympiad")
                .dataSource(url, user, password)
                .load();

        flyway.migrate();
        System.out.println("✅ Flyway migration completed");
    }
}
