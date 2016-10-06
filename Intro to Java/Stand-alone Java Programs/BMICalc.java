package edu.bu.met.cs232;

/**
 * edu.bu.met.cs232.BMICalc
 * created by Jennifer Konikowski on 1/24/16
 *
 *  This application takes a user's weight and height and calculates BMI.
 *
 *  Problem 2.33, page 67 of Java Early Objects:
 *  Create a BMI calculator that reads the user's weight in pounds and height in inches,
 *  then calculates and displays the user's body mass index. Also, display information to
 *  help the user evaluate their BMI.
 *
 */

import java.util.Scanner; // program uses class Scanner to get user input
public class BMICalc {

    public static void main(String[] args) {
        // create Scanner to obtain user input
        Scanner input = new Scanner(System.in);

        float height, weight, bmi; // create input variables and end results as floats to increase accuracy
        // describe the program to the user
        System.out.printf("%s%n%s%n", "This program takes your height (inches) and", "weight (lbs) and returns BMI");

        System.out.print("Enter your height (inches): "); // prompt
        height = input.nextFloat(); // reads height from user

        System.out.print("Enter your weight (lbs): "); // prompt
        weight = input.nextFloat(); // reads weight from user

        bmi = (weight * 703) / (height * height); // calculate BMI, multiplying by 703 since not using metric
        System.out.printf("Your BMI is %.1f%n%n", bmi); // display BMI to users, using .1 to only display the decimal to the 10th

        // print out lines displaying BMI information
        System.out.println("BMI VALUES");
        System.out.println("Underweight: less than 18.5");
        System.out.println("Normal:      between 18.5 and 24.9");
        System.out.println("Overweight:  between 25 and 29.9");
        System.out.println("Obese:       30 or greater");
    } // end main
} // end BMICalc