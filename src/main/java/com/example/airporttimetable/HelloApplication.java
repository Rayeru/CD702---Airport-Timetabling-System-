package com.example.airporttimetable;

import com.example.airporttimetable.database.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // to test database connection
                try {
                    DatabaseConnection.getConnection();
                    System.out.println("Database Connected Successfully!");
                } catch (Exception e) {
                    System.out.println("Database Connection Failed!");
                    e.printStackTrace();
                }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
