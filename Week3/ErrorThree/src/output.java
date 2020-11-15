/*
 * Jaime Rodriguez
 * Assignment 3.2
 * November 15, 2020
 *
 * Purpose: Correct bug error in classmates
 * program to function properly
 *
 * To compile the program:
 * javac output.java
 *
 * To execute the program:
 * java output
 *
 */

// Missing "import" statement
import java.io.PrintWriter;

class Main {
    public static void main(String[] args) {

        try {
            PrintWriter output = new PrintWriter("output.txt");

            int age = 25;

            output.printf("I am %d years old. ", age);
            // Closing statement had not variable attached
            // Included output
            output.close();
        }

        // Catch statement was inside try statement
        // Catch statement moved outside of try statement
        catch (Exception e) {
            e.getStackTrace();
        }
    }
// Missing closing brace
}