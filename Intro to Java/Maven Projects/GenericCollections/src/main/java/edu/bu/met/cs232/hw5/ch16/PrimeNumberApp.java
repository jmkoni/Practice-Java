package edu.bu.met.cs232.hw5.ch16;

import java.util.Scanner;

/**
 * Created by jmkoni on 3/31/16.
 */
public class PrimeNumberApp {
  public static void main( String[] args )
  {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a number: ");
    int number = input.nextInt();
    PrimeNumber primeNumber = new PrimeNumber(number);
    System.out.println(primeNumber.returnTextPrimes());
    input.close();
  }
}
