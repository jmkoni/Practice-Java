package edu.bu.met.cs232;

import java.util.Scanner;

/**
 * HealthInformation.java
 * 3.17
 * Created by Jennifer Konikowski on 2/6/16.
 *
 * This app prompts for the person's information (first name, last name, birthdate (month, day, year), gender, height, weight),
 * instantiates an object of class HealthProfile and prints the information from that object -- including
 * the first name, last name, gender, height, weight, and date of birth--then calculates and prints the person's age in years,
 * maximum heart rate, target heart rate, and BMI. It should also display BMI values chart.
 */
public class HealthInformation {
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
        System.out.print("Enter your height (inches): "); // prompt
        float height = input.nextFloat(); // reads height from user
        System.out.print("Enter your weight (lbs): "); // prompt
        float weight = input.nextFloat(); // reads weight from user

        // create heartrate object
        HealthProfile profile1 = new HealthProfile(firstName, lastName, birthMonth, birthDay, birthYear, height, weight);

        // print out information
        System.out.println("Health Information Information");
        System.out.printf("%s %s - %d/%d/%d%nAge: %d%nHeight: %.1f in.%nWeight: %.1f lbs.%n" +
                "Target Heart Rate: %d - %d bmp%nMax Heart Rate: %d bpm%nBMI: %.1f%n%n",
                profile1.getFirstName(), profile1.getLastName(), profile1.getBirthMonth(),
                profile1.getBirthDay(), profile1.getBirthYear(), profile1.getAge(), profile1.getHeight(),
                profile1.getWeight(), profile1.minTargetRate(), profile1.maxTargetRate(), profile1.maxRate(),
                profile1.bodyMassIndex());
        profile1.bmiValues();
    }
}
