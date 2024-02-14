package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
