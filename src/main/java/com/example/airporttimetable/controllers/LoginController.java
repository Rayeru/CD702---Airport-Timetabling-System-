package com.example.airporttimetable.controllers;

import com.example.airporttimetable.services.UserService;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    private final UserService userService = new UserService();

    private static final Logger LOGGER =
            Logger.getLogger(LoginController.class.getName());

    // Receive and validate login credentials
    public String loginUser(String username, String password) {

        // Validate username
        if (username == null || username.isBlank()) {
            return "Username is required.";
        }

        // Validate password
        if (password == null || password.isBlank()) {
            return "Password is required.";
        }

        try {

            boolean authenticated = userService.authenticateUser(
                    username.trim(), password
            );

            if (authenticated) {
                return "SUCCESS";
            }

            return "Invalid username or password.";

        } catch (SQLException e) {

            LOGGER.log(Level.SEVERE, "Database connection error.", e);

            return "Unable to sign in. Please try again later.";

        } catch (IllegalArgumentException e) {

            LOGGER.log(Level.SEVERE, "Invalid stored password hash.", e);

            return "Unable to sign in. Please try again later.";
        }
    }
}