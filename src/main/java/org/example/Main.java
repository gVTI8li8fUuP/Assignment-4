package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
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
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8080/users/add");


            httpPost.setHeader("Content-Type", "application/json");


            String json = "{\"name\":\"John\",\"surname\":\"Doe\",\"gender\":true}";


            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);


            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {

                System.out.println(response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
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



    @SpringBootApplication
    public class UserApplication {

        public static void main(String[] args) {
            SpringApplication.run(UserApplication.class, args);
        }
    }

}