package com.example.assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public
class ClassroomOrganiser extends Application {
    @Override
    public
    void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader (ClassroomOrganiser.class.getResource ("seating-plan.fxml"));
        Scene scene = new Scene (fxmlLoader.load ());
        stage.setTitle ("Class Organiser");
        stage.setResizable (false);
        stage.setScene (scene);
        stage.show ();
    }

    public static
    void main(String[] args) {
        launch ();
    }
}