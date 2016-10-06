package edu.bu.met.cs232;

/**
 * edu.bu.met.cs232.hw1.OneToFour
 * Created by Jennifer Konikowski on 1/23/16.
 *
 *  This application prints out "12 34" using three different print functions: println, print, printf
 *  Problem 2.14, page 64 of Java Early Objects:
 *  Write an application that displays the numbers 1 to 4 on the same line, with each pair of adjacent numbers separated by one space.
 *
 *  Given this text, I'm assuming given the problem text that the output should be "12 34".
 *
 */

public class OneToFour {

    public static void main(String[] args) {
        // output using a single println
        System.out.println("12 34");
        // output using 4 prints
        System.out.print("1");
        System.out.print("2 ");
        System.out.print("3");
        System.out.print("4\n");
        // output using a single printf
        System.out.printf("%s %s%n", "12", "34");
    } // end main
} // end OneToFour