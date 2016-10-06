package edu.bu.met.cs232;

import java.util.Scanner;
import java.util.Arrays;

/**
 * CheckProtection.java
 * 14.20
 * Created by Jennifer Konikowski on 2/7/16.
 *
 * This applications inputs a dollar amount to be printed on a chekc, then prints
 * the amount in a check-protected format with leading asterisks if necessary.
 * Assume that nine spaces are available for the amount
 */
public class CheckProtection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter amount for check: "); //prompt
        String amount = input.nextLine(); //get amount
        String convertedAmount; // initialize converted
        int amountLength = amount.length(); // determine length of string
        if (amountLength < 9){ // if less than nine, then add asterisks
            int lengthDiff = 9 - amountLength; // get number of asterisks needed
            char[] repeat = new char[lengthDiff]; // create a new char array of the correct length
            Arrays.fill(repeat, '*'); // fill the array with asterisks
            convertedAmount = new String(repeat) + amount; // add asterisks to the beginning of the string
        } else {
            convertedAmount = amount;
        }
        System.out.println("Converted amount: " + convertedAmount); // print out the converted amount
    }
}