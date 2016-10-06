package edu.bu.met.cs232;

/**
 * edu.bu.met.cs232.hw1.CubesAndSquare
 * Created by Jennifer Konikowski on 1/24/16.
 *
 *  This application prints out the cubes and squares of the numbers 1 through 10
 *  Problem 2.31, page 67 of Java Early Objects:
 *  Using only the programming techniques learned in chapter 2, write an application that calculates
 *  the squares and cubes of the numbers from 0 to 10 and print the resulting values in table format.
 *
 *  This would be just a few lines with a for loop, but given that this chapter just covered if
 *  statements, I hardcoded the numbers.
 *
 */

public class CubesAndSquares {

    public static void main(String[] args) {
        System.out.println("number   square   cube"); // print out header
        System.out.printf("%d        %d        %d%n", 0, 0*0, 0*0*0); // for zero
        System.out.printf("%d        %d        %d%n", 1, 1*1, 1*1*1); // for one
        System.out.printf("%d        %d        %d%n", 2, 2*2, 2*2*2); // for two
        System.out.printf("%d        %d        %d%n", 3, 3*3, 3*3*3); // for three
        System.out.printf("%d        %d       %d%n", 4, 4*4, 4*4*4); // for four
        System.out.printf("%d        %d       %d%n", 5, 5*5, 5*5*5); // for five
        System.out.printf("%d        %d       %d%n", 6, 6*6, 6*6*6); // for six
        System.out.printf("%d        %d       %d%n", 7, 7*7, 7*7*7); // for seven
        System.out.printf("%d        %d       %d%n", 8, 8*8, 8*8*8); // for eight
        System.out.printf("%d        %d       %d%n", 9, 9*9, 9*9*9); // for nine
        System.out.printf("%d       %d      %d%n", 10, 10*10, 10*10*10); // for ten

    } // end main
} // end CubesAndSquares