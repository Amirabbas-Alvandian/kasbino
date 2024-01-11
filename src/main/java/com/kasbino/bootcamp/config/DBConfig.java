package com.kasbino.bootcamp.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private final String URL = "jdbc:postgresql://localhost/kasbino";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "post457";
    private static Connection connection;

    public Connection getConnection(){
        if (connection == null){
            try {
                return DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
