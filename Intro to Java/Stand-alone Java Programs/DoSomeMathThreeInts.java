package edu.bu.met.cs232;

/**
 * edu.bu.met.cs232.hw1.DoSomeMathThreeInts
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
public class DoSomeMathThreeInts {

    public static void main(String[] args) {
        // create Scanner to obtain user input
        Scanner input = new Scanner(System.in);

        int number1, number2, number3, sum, product, average, smallest, largest; // create input variables and end results
        // describe the program to the user
        System.out.printf("%s%n%s%n", "This program takes three integers and then", "returns the sum, product, average, smallest & largest.");

        System.out.print("Enter first integer: "); // prompt
        number1 = input.nextInt(); // reads first integer from user

        System.out.print("Enter second integer: "); // prompt
        number2 = input.nextInt(); // reads second integer from user

        System.out.print("Enter third integer: "); // prompt
        number3 = input.nextInt(); // reads third integer from user

        sum = number1 + number2 + number3; // find sum of numbers
        product = number1 * number2 * number3;  // find product of numbers
        average = sum / 3; // find average

        if (number1 < number2)
        {
            smallest = number1;
            largest = number2;
        } else {
            smallest = number2;
            largest = number1;
        }

        if (number3 < smallest)
        {
            smallest = number3;
        } else if (number3 > largest) {
            largest = number3;
        }

        System.out.printf("Sum is %d%n", sum); // print out sum
        System.out.printf("Product is %d%n", product); // print out product
        System.out.printf("Average is %d%n", average); // print out average
        System.out.printf("Smallest number is %d%n", smallest); // print out smallest
        System.out.printf("Largest number is %d%n", largest); // print out largest
    } // end main
} // end DoSomeMathThreeInts