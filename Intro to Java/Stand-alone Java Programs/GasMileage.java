package edu.bu.met.cs232;
/**
 * GasMileage.java
 * 4.17
 * Created by Jennifer Konikowski on 2/7/2016
 *
 * Keep track of several trips by recording the miles driven and gallons used for each tankful.
 * This application inputs the miles driven and gallons used (both as integers) for each trip.
 * Then it calculates and displays the miles per gallon obtained each trip, then print the combined
 * miles per gallon obtained for all trips up to this point. All averaging calculations should produce
 * floating point results. Use sentinel-controlled repetition to obtain data from the user.
 */

import java.util.Scanner;
public class GasMileage {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int milesDriven = -1;// initialize int for loop
        int gallonsUsed;
        int totalGallons = 0;
        int totalMiles = 0;
        float overallAverage, tripAverage;
        while (milesDriven != 0) {
            System.out.print("Please enter your mileage (0 to quit): "); //prompt
            milesDriven = input.nextInt(); // get milesDriven input
            if (milesDriven != 0) {
                totalMiles += milesDriven; // add to total overall miles
                System.out.print("Please enter your gallons used (0 to quit): "); //prompt
                gallonsUsed = input.nextInt(); // get gallonsUsed input
                totalGallons += gallonsUsed; // add to total overall gallons
                tripAverage = (float) milesDriven / gallonsUsed; // calculate trip average
                overallAverage = (float) totalMiles / totalGallons; // calculate overall average
                System.out.printf("Trip Average: %.2f mpg%nOverall Average: %.2f mpg%n%n", tripAverage, overallAverage);
            }
        }
    }
}
