package edu.bu.met.cs232.hw5.ch7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DuplicateElimination
 * 7.12
 * Created by jmkoni on 4/2/16.
 *
 * Use a one-dimensional array to solve the following problem: Write an application
 * that inputs five numbers, each between 10 and 100, inclusive. As each number is
 * read, display it only if it’s not a duplicate of a number already read. Provide for
 * the “worst case,” in which all five numbers are different. Use the smallest possible
 * array to solve this problem. Display the complete set of unique values input after
 * the user enters each new value.
 *
 * I wasn't sure of how to implement this, so I chose to loop until I got five numbers
 * inputted by the user that matched the parameters that I wanted. I initially looked
 * at implementing this in it's own class, but due to the way I had to loop, it didn't
 * really make any sense in the end.
 */
public class DuplicateElimination {
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    int[] numbers = new int[5];
    boolean inNumbers;
    int currentNum = 0;
    for(int i = 0; i < 5; i++){
      boolean invalidNumber = true;
      while(invalidNumber) {
        inNumbers = false;
        System.out.print("Please enter a number between 10 and 100, inclusive: ");
        currentNum = input.nextInt();
        if (currentNum >= 10 && currentNum <= 100) {
          for (int j : numbers) {
            if (currentNum == j) {
              inNumbers = true;
            }
          }
          if(!inNumbers){
            invalidNumber = false;
          }
        }
      }
      numbers[i] = currentNum;
    }

    System.out.println("Array: " + Arrays.toString(numbers));
    input.close();
  }
}
