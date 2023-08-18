package com.example.assignment3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public
class SeatingPlan {

    /* Store the declared students in an associative array, with the student name and the colour of their seat */
    private Map<String, String> studentPlacement = new HashMap<> ();

    /* An array with all the available seats. Start with all seats upon starting the program,
       and remove each seat that is chosen at random.
    The seats visually are:
    * 1     2     3
    * 4     5     6
    * 7     8     9     */
    private ArrayList<String> seats = new ArrayList<String> () {{
        add ("col1row1");
        add ("col2row1");
        add ("col3row1");
        add ("col1row2");
        add ("col2row2");
        add ("col3row2");
        add ("col1row3");
        add ("col2row3");
        add ("col3row3");
    }};
    private static Random random = new Random ();    // Object for finding a random seat

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

    @FXML
    void addStudent(ActionEvent event) {
        boolean validStudent = true;                    // Determine if the student name + colour combo is valid

        if (seats.isEmpty ()) setErrorMessage ();         // Button will display an error if all seats are full

        else {
            int seat = random.nextInt (seats.size ());    // Find a random index to compare to the seats array
            // Do not allow the user to enter an empty name or white background
            if (studentName.getText ().equals ("") || seatColour.getValue ().toString ().equals ("0xffffffff")) {
                setErrorMessage ();
            } else {
                for (String student : studentPlacement.keySet ()) {  // Loop through the student names of declared students
                    // If the student has the same name or seat colour as a declared student, the student is invalid
                    if (studentName.getText ().equals (student) || seatColour.getValue ().toString ().equals (studentPlacement.get (student))) {
                        System.out.println ("Error");
                        validStudent = false;
                    }
                }
                // If the student name and colour is unique, the student will be added to the class
                if (validStudent) {
                    switch (seats.get (seat)) {      // Use the random int to find the available seat at that index
                        case "col1row1" -> {        // Assign the student to the random seat in the seats array
                            col1row1.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                            col1row1Label.setText (studentName.getText ());
                            assignSeat (seat);       // Remove the seat from the available seats, and put the student in the declared students array
                        }
                        case "col2row1" -> {
                            col2row1.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                            col2row1Label.setText (studentName.getText ());
                            assignSeat (seat);
                        }
                        case "col3row1" -> {
                            col3row1.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                            col3row1Label.setText (studentName.getText ());
                            assignSeat (seat);
                        }
                        case "col1row2" -> {
                            col1row2.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                            col1row2Label.setText (studentName.getText ());
                            assignSeat (seat);
                        }
                        case "col2row2" -> {
                            col2row2.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                            col2row2Label.setText (studentName.getText ());
                            assignSeat (seat);
                        }
                        case "col3row2" -> {
                            col3row2.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                            col3row2Label.setText (studentName.getText ());
                            assignSeat (seat);
                        }
                        case "col1row3" -> {
                            col1row3.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                            col1row3Label.setText (studentName.getText ());
                            assignSeat (seat);
                        }
                        case "col2row3" -> {
                            col2row3.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                            col2row3Label.setText (studentName.getText ());
                            assignSeat (seat);
                        }
                        case "col3row3" -> {
                            col3row3.setStyle ("-fx-background-color: #" + seatColour.getValue ().toString ().substring (2));
                            col3row3Label.setText (studentName.getText ());
                            assignSeat (seat);
                        }
                    }
                }
            }
        }
    }

    // Manage the array of available seats and set the student as declared
    void assignSeat(int seat) {
        seats.remove (seat);
        studentPlacement.put (studentName.getText (), String.valueOf (seatColour.getValue ()));
    }

    void setErrorMessage() {
        System.out.println ("Error");
    }
}