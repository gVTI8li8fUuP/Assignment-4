package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/simpledb";
        String user = "postgres";
        String password = "Rahat676869";
        Connection con = null;


        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Подключение к PostgreSQL установлено");

        } catch (SQLException e) {
            System.out.println("Ошибка подключения к PostgreSQL");
            e.printStackTrace();
        }
    }
    @Component
    public class MyComponent {

        @Value("${spring.datasource.url}")
        private String dbUrl;

        @Value("${spring.datasource.username}")
        private String dbUsername;

        @Value("${spring.datasource.password}")
        private String dbPassword;

        public String getDbUrl() {
            return dbUrl;
        }

        public void setDbUrl(String dbUrl) {
            this.dbUrl = dbUrl;
        }

        public String getDbUsername() {
            return dbUsername;
        }

        public void setDbUsername(String dbUsername) {
            this.dbUsername = dbUsername;
        }

        public String getDbPassword() {
            return dbPassword;
        }

        public void setDbPassword(String dbPassword) {
            this.dbPassword = dbPassword;
        }
    }
    @SpringBootApplication
    public class DailyQuoteApplication {

        public static void main(String[] args) {
            SpringApplication.run(DailyQuoteApplication.class, args);
        }
    }


}