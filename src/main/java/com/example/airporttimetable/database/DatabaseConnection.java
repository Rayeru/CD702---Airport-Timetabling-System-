package com.example.airporttimetable.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // the database name might be different for you
    // so change this "rry12_CD702_AirportTimetable" to match you database name
    private static final String URL = "jdbc:mysql://localhost:3306/rry12_CD702_AirportTimetable";

    private static final String USER = "root";

    private static final String PASSWORD = "your_password";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}
