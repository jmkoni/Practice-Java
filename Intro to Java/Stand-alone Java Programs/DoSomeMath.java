package edu.bu.met.cs232;

/**
 * edu.bu.met.cs232.DoSomeMath
 * created by Jennifer Konikowski on 1/23/16
 *
 *  This application takes two numbers from user input and displays their sum, difference, product, & quotient to the screen
 *
 *  Problem 2.15, page 65 of Java Early Objects:
 *  Write an application that asks the user to enter two integers, obtains them from the user and prints their sum,
 *  product, difference, and quotient.
 *
 */

import java.util.Scanner; // program uses class Scanner to get user input
public class DoSomeMath {

    public static void main(String[] args) {
        // create Scanner to obtain user input
        Scanner input = new Scanner(System.in);

        int number1, number2, sum, product, difference; // create input variables and end results
        float quotient; //create quotient as float to achieve a more accurate result
        // describe the program to the user
        System.out.printf("%s%n%s%n", "This program takes two integers and then", "performs mathematical operations on them.");

        System.out.print("Enter first integer: "); // prompt
        number1 = input.nextInt(); // reads first integer from user

        System.out.print("Enter second integer: "); // prompt
        number2 = input.nextInt(); // reads second integer from user

        sum = number1 + number2; // find sum of numbers
        difference = number1 - number2; // find difference of numbers
        quotient = number1 / (float) number2; // find quotient of numbers, casting number2 as a float to get a more accurate result
        product = number1 * number2;  // find product of numbers

        System.out.printf("%d + %d = %d%n", number1, number2, sum); // print out sum
        System.out.printf("%d - %d = %d%n", number1, number2, difference); // print out difference
        System.out.printf("%d * %d = %d%n", number1, number2, product); // print out product
        System.out.printf("%d / %d = %f%n", number1, number2, quotient); // print out quotient
    } // end main
} // end DoSomeMath