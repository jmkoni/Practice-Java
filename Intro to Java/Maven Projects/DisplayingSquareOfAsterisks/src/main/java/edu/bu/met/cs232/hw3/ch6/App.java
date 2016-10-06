package edu.bu.met.cs232.hw3.ch6;

/**
 * DisplayingSquareOfAsterisks
 * 6.18
 * Created by Jennifer Konikowski on 2/15/16.
 *
 * Write a method squareOfAsterisks that displays a solid square (the same number of
 * rows and columns) of asterisks whose side is specified in integer parameter side.
 * For example, if side is 4, the method should display
 *   ****
 *   ****
 *   ****
 *   ****
 *
 * Incorporate this method into an application that reads an integer value for side
 * from the user and outputs the asterisks with the squareOfAsterisks method.
 */

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of sides: ");
        int num_sides = input.nextInt(); // read in int for number of sides
        squareOfAsterisks(num_sides); // pass int to squareOfAsterisks method
        input.close();
    } // end main

    // this method simple returns a square of asterisks the size of the given int
    public static void squareOfAsterisks(int sides){
        for(int i = 0; i < sides; i++){ // loop for each row
            for(int j = 0; j < sides; j++){ // loop for each column
                System.out.print("*");
            }
            System.out.println("");
        }
    } // end squareOfAsterisks
} // DisplayingSquareOfAsterisks
