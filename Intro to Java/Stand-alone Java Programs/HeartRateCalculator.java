package edu.bu.met.cs232;

import java.util.Scanner;

/**
 * HeartRateCalculator.java
 * 3.16
 * Created by Jennifer Konikowski on 2/6/16.
 *
 * This app prompts for the person's information (first name, last name, birthdate (month, day, year)),
 * instantiates an object of class HeartRates and prints the information from that object -- including
 * the first name, last name and date of birth--then calculates and prints the person's age in years,
 * maximum heart rate, and target heart rate.
 */
public class HeartRateCalculator {
    public static void main(String[] args) {
        // create a scanner object
        Scanner input = new Scanner(System.in);

        // get user input
        System.out.print("Enter first name: ");
        String firstName = input.nextLine(); // obtain user input
        System.out.print("Enter last name: ");
        String lastName = input.nextLine(); // obtain user input
        System.out.print("Enter birth month (integer, 1-12): ");
        int birthMonth = input.nextInt(); // obtain user input
        System.out.print("Enter birth day (integer, 1-31): ");
        int birthDay = input.nextInt(); // obtain user input
        System.out.print("Enter birth year (integer): ");
        int birthYear = input.nextInt(); // obtain user input

        // create heartrate object
        HeartRates heartRate1 = new HeartRates(firstName, lastName, birthMonth, birthDay, birthYear);

        // print out information
        System.out.println("Heart Rate Information");
        System.out.printf("%s %s - %d/%d/%d%nAge: %d%nTarget Heart Rate: %d - %d bmp%nMax Heart Rate: %d bpm%n%n",
                heartRate1.getFirstName(), heartRate1.getLastName(), heartRate1.getBirthMonth(), heartRate1.getBirthDay(),
                heartRate1.getBirthYear(), heartRate1.getAge(), heartRate1.minTargetRate(), heartRate1.maxTargetRate(), heartRate1.maxRate());

    } // end main
} // end HeartRateCalculator
