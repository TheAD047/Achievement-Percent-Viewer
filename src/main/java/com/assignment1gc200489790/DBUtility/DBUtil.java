package com.assignment1gc200489790.DBUtility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static String user = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/F22";

    private static Connection startConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }
        catch (Exception e) {
            System.out.println("session not commenced...");
            e.printStackTrace();
            return null;
        }
    }
}
