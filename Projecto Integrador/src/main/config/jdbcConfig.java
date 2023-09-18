package main.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConfig {
    private static final String DB_DRIVER = "org.h2.Driver";
    // private static final String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'classpath:nombre_del_archivo.sql'";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
