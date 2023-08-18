package com.example.assignment3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public
class ClassroomController {

    @FXML
    private Pane col1row1;

    @FXML
    private Label col1row1Label;

    @FXML
    private Pane col1row2;

    @FXML
    private Label col1row2Label;

    @FXML
    private Pane col1row3;

    @FXML
    private Label col1row3Label;

    @FXML
    private Pane col2row1;

    @FXML
    private Label col2row1Label;

    @FXML
    private Pane col2row2;

    @FXML
    private Label col2row2Label;

    @FXML
    private Pane col2row3;

    @FXML
    private Label col2row3Label;

    @FXML
    private Pane col3row1;

    @FXML
    private Label col3row1Label;

    @FXML
    private Pane col3row2;

    @FXML
    private Label col3row2Label;

    @FXML
    private Pane col3row3;

    @FXML
    private Label col3row3Label;

    @FXML
    private ColorPicker seatColour;

    @FXML
    private TextField studentName;

    private static final ClassroomModel MODEL = new ClassroomModel ();
    ;

    @FXML
    void addStudent(ActionEvent event) {
        try {
            String placement = MODEL.findSeat (studentName.getText (), seatColour.getValue ().toString ());

            switch (placement) {            // Use the random seat from ClassroomModel to find the available seat at that index
                case "col1row1" -> {        // Assign the student to the random seat in the seats array
                    col1row1.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                    col1row1Label.setText (studentName.getText ());
                }
                case "col2row1" -> {
                    col2row1.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                    col2row1Label.setText (studentName.getText ());
                }
                case "col3row1" -> {
                    col3row1.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                    col3row1Label.setText (studentName.getText ());
                }
                case "col1row2" -> {
                    col1row2.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                    col1row2Label.setText (studentName.getText ());
                }
                case "col2row2" -> {
                    col2row2.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                    col2row2Label.setText (studentName.getText ());
                }
                case "col3row2" -> {
                    col3row2.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                    col3row2Label.setText (studentName.getText ());
                }
                case "col1row3" -> {
                    col1row3.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                    col1row3Label.setText (studentName.getText ());
                }
                case "col2row3" -> {
                    col2row3.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                    col2row3Label.setText (studentName.getText ());
                }
                case "col3row3" -> {
                    col3row3.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                    col3row3Label.setText (studentName.getText ());
                }
            }
        }
        // Alert the user of an errors that were thrown, if any
        catch (Exception e) {
            Utilities.createErrorAlert (e.getMessage ()).show ();
        }
    }
}
