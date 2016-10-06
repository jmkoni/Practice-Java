package edu.bu.met.cs232.h3.ch6;

/**
 * edu.bu.met.cs232.ParkingCharges
 * 6.8
 * Created by Jennifer Konikowski on 2/15/16.
 *
 * A parking garage charges a $2.00 minimum fee to park for up to three hours.
 * The garage charges an additional $0.50 per hour for each hour or part thereof
 * in excess of three hours.The maximum charge for any given 24-hour period is $10.00.
 * Assume that no car parks for longer than 24 hours at a time. Write an application
 * that calculates and displays the parking charges for each customer who parked in the
 * garage yesterday. You should enter the hours parked for each customer. The program
 * should display the charge for the current customer and should calculate and display
 * the running total of yesterday’s receipts. It should use the method calculateCharges
 * to determine the charge for each customer.
 */
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num_hours;
    float total_charges = 0.0f; // initialize total_charge so can add to itself
    float cus_charge;
    while (true) { // end while with break statement
      System.out.print("Please enter number of hours customer parked (0 to quit): ");
      num_hours = input.nextInt();
      if (num_hours == 0) {
        break; // if zero is entered, break out of loop
      }
      cus_charge = calculateCharges(num_hours); // pass num_hours to function
      total_charges += cus_charge; // add current customer charge to total charge
      System.out.printf("Customer charged: $%.2f.%n", cus_charge);
      System.out.printf("Running total: $%.2f.%n", total_charges);
    }
    // print out the final total once all customers are entered
    System.out.printf("Final total for yesterday: $%.2f.%n", total_charges);
    input.close();
  } // end main

  //This function calculates how much a customer owes the garage.
  public static float calculateCharges(int hours) {
    float charge;
    if (hours <= 4) { // minimum charge is $2
      charge = 2.00f;
    } else if (hours >= 20) { // max charge is $10
      charge = 10.00f;
    } else { // otherwise, it's .50 an hour
      charge = 0.50f * hours;
    }
    return charge;
  } // end calculateCharges
}