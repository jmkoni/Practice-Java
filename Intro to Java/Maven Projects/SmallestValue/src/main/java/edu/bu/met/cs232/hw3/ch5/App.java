package edu.bu.met.cs232.hw3.ch5;

/**
 * SmallestValue
 * 5.11
 * Created by Jennifer Konikowski on 2/14/16.
 *
 * This is an application that finds the smallest of several integers.
 * Assume that the first value read specifies the number of values to input from the user.
 * Loop through number of values, getting a new integer each time. During each loop,
 * reassign the smallest value depending on whether or not it is less than current
 * smallest.
 */
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter number of integers: "); //prompt
    int num_ints = input.nextInt(); // get number of ints to be compared
    // if 0 (or negative) is entered, exit the program
    if(num_ints <= 0){
      System.out.println("Since you entered 0, exiting the program");
      System.exit(0);
    }
    int smallest_value, current_int;
    System.out.print("Enter an integer: ");
    smallest_value = input.nextInt();
    for (int i = 1; i < num_ints; i++) {
      System.out.print("Enter an integer: ");
      current_int = input.nextInt();
      smallest_value = returnSmallestInt(current_int, smallest_value);
    }

    System.out.printf("The smallest integer is %d.%n", smallest_value);
    input.close(); // close scanner
  }

  public static int returnSmallestInt(int current_int, int smallest_value) {
    if (current_int < smallest_value) {
      return current_int;
    } else {
      return smallest_value;
    }
  }
}
