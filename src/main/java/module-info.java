module com.example.airporttimetable {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.airporttimetable to javafx.fxml;
    exports com.example.airporttimetable;
}