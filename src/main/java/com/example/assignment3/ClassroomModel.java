package com.example.assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public
class ClassroomModel {

    /* Store the declared students in an associative array, with the student name and the colour of their seat */
    private Map<String, String> studentPlacement = new HashMap<> ();

    /* Start with all seats upon starting the program, and remove each seat that is chosen at random. */
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
    // Object for finding a random seat
    private static Random random = new Random ();

    public
    ArrayList<String> getSeats() {
        return seats;
    }

    public
    boolean isClassFull() {
        return getSeats ().isEmpty ();
    }

    public
    String findSeat(String studentName, String seatColour) {
        String seatReturned = "";

        if (!isClassFull ()) {
            // Find a random index to compare to the seats array
            int seat = random.nextInt (getSeats ().size ());
            // Do not allow the user to enter an empty name, whitespace, or white background
            if (studentName.equals ("") || studentName.equals (" ") || seatColour.equals ("0xffffffff")) {
                throw new IllegalArgumentException ("Please enter a non-empty name and a colour other than pure white.");
            } else {
                // Loop through the student names of declared students
                for (String student : studentPlacement.keySet ()) {
                    // If the student has the same seat colour as a declared student, throw an exception
                    if (seatColour.equals (studentPlacement.get (student))) {
                        throw new IllegalArgumentException ("That colour has already been claimed, please pick a new one.");
                    }
                }
                // If the colour is unique, the student will be added to the class
                seatReturned = getSeats ().get ((seat));
                assignSeat (seat, studentName, seatColour);
            }
        } else {
            throw new IllegalArgumentException ("Your classroom is full.");
        }
        return seatReturned;
    }

    // Remove the seat from the available seats, and put the student in the declared students array
    void assignSeat(int seat, String studentName, String seatColour) {
        seats.remove (seat);
        studentPlacement.put (studentName, String.valueOf (seatColour));
        // Check if the class is full after removing the latest seat. Congratulate user if it is
        if (isClassFull ()) Utilities.createCongratulatoryAlert ();
    }
}
