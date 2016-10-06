package edu.bu.met.cs232.hw5.ch7;

/**
 * EnhancedFor
 * 7.16
 * Created by jmkoni on 4/2/16.
 *
 * Write an application that uses an enhanced for statement to sum the double values
 * passed by the command-line arguments. [Hint: Use the static method parseDouble of
 * class Double to convert a String to a double value.]
 */
public class EnhancedFor {
  public static void main(String args[]){
    double total = 0;
    for (String s: args) {
      try {
        double currentNum = Double.parseDouble(s);
        total += currentNum;
      } catch (NumberFormatException e) {
        System.err.println("Arguments must be doubles.");
      }
    }

    System.out.println("Total of all numbers: " + total);
  }
}
