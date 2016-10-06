package edu.bu.met.cs232.hw3.ch6;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ReversingDigits
 * 6.26
 * Created by Jennifer Konikowski on 2/20/16.
 *
 * This application will reverse digits. It contains a method that takes an integer
 * value and returns the number with its digits reversed. For example, given the number
 * 7631, the method should return 1367. Incorporate the method into an application that
 * reads a value from the user and displays the result.
 *
 * The reverseDigits method reverses the number first by getting each number by 10s and
 * pushing it into a linkedlist. That leaves with a list like: [7,6,3,1]. Then the last
 * is removed and added to a string until the list is empty. Then we have a string that
 * looks like "1367". The last step is to parse the string as an integer.
 */
public class App 
{
  public static void main( String[] args )
  {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter integer to be reversed: ");
    int initialNumber = input.nextInt();
    int reversed = reverseDigits(initialNumber);
    System.out.printf("%d reverse is: %d%n", initialNumber, reversed);
    input.close();
  }

  public static int reverseDigits(int initial){
    LinkedList<Integer> stack = new LinkedList<Integer>();
    String stringReverse = "";
    while (initial > 0) {
      stack.push( initial % 10 );
      initial = initial / 10;
    }
    while (stack.size() > 0) {
      stringReverse = stringReverse + stack.removeLast();
    }
    return Integer.parseInt(stringReverse);

  }
}
