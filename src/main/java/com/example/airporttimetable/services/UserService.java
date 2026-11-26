package com.example.airporttimetable.services;
import com.example.airporttimetable.database.DatabaseConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserService {

    // Authenticate a user using their username and password
    public boolean authenticateUser(String username, String password)
            throws SQLException {

        String sql = "SELECT Password FROM user WHERE Username = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    String storedPassword = resultSet.getString("password");

                    // Compare the entered password with the stored hash
                    return BCrypt.checkpw(password, storedPassword);
                }
            }
        }

        // No matching user was found
        return false;
    }
}