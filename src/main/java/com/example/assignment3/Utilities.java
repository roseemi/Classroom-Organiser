package com.example.assignment3;

import javafx.scene.control.Alert;

public class Utilities {
    // Create an error message to tell the user what went wrong
    static Alert createErrorAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(content);
        return alert;
    }

    // Congratulate the user upon first filling the class layout
    static void createCongratulatoryAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulations!");
        alert.setHeaderText("Congratulations!");
        alert.setContentText("Your classroom set up is complete!");
        alert.showAndWait();
    }
}

