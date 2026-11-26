module com.example.airporttimetable {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;
    requires java.logging;


    opens com.example.airporttimetable to javafx.fxml;
    exports com.example.airporttimetable;
}