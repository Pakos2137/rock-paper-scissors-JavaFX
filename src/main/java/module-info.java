module com.tictactoegui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rockpaperscissorsjavafx to javafx.fxml;
    exports com.example.controllers;
    exports com.example.rockpaperscissorsjavafx;
    opens com.example.controllers to javafx.fxml;
}