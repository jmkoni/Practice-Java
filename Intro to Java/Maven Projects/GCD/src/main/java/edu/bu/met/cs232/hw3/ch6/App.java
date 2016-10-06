package edu.bu.met.cs232.hw3.ch6;

import java.util.Scanner;

/**
 * GreatestCommonDivisor
 * 6.27
 * created by Jennifer Konikowski 2/20/2016
 *
 *The greatest common divisor (GCD) of two integers is the largest integer that evenly
 * divides each of the two numbers. Write a method gcd that returns the greatest common
 * divisor of two integers. [Hint: You might want to use Euclid’s algorithm. You can
 * find information about it at en.wikipedia.org/wiki/Euclidean_algorithm.] Incorporate
 * the method into an application that reads two values from the user and displays the
 * result.
 */
public class App
{
  public static void main( String[] args )
  {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter first integer: ");
    int numOne = input.nextInt();
    System.out.print("Enter second integer: ");
    int numTwo = input.nextInt();
    int gcd = euclid(numOne, numTwo);
    System.out.printf("The greatest common divisor of %d and %d is %d.%n", numOne,
        numTwo, gcd);
    input.close();
  }

  public static int euclid(int a, int b){
    if(b == 0) {
      return a;
    } else {
      return euclid(b, a % b);
    }
  }
}