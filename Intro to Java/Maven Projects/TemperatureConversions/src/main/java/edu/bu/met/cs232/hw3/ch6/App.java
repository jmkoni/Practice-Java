package edu.bu.met.cs232.hw3.ch6;

/**
 * edu.bu.met.cs232.TemperatureConversions
 * 6.22
 * Created by Jennifer Konikowski on 2/15/16.
 *
 * Implement the following integer methods:
 *  a) Method celsius returns the Celsius equivalent of a Fahrenheit temperature, using
 *  the calculation
 *    celsius = 5.0 / 9.0 * (fahrenheit - 32);
 *  b) Method fahrenheit returns the Fahrenheit equivalent of a Celsius temperature,
 *  using the calculation
 *    fahrenheit = 9.0 / 5.0 * celsius + 32;
 *  c) Use the methods from parts (a) and (b) to write an application that enables the
 *  user either to enter a Fahrenheit temperature and display the Celsius equivalent or
 *  to enter a Celsius temperature and display the Fahrenheit equivalent.
 */

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter current temperature, followed by F or C: ");
    String temp = input.nextLine(); // read in temp and unit
    String[] temp_plus_unit = splitInput(temp);
    String unit = temp_plus_unit[1].substring(0,1); // get the unit
    float just_temp = Float.parseFloat(temp_plus_unit[0]); // get the temp as a
    // float
    String result = compareTemps(unit, just_temp, temp);
    System.out.println(result);
    input.close();
  } // end main

  // this method just returns the string that will be printed out
  // I originally made this part of main, but split it to improve testability
  public static String compareTemps(String unit, float just_temp, String temp){
    float converted_temp;
    if (unit.equals("F") || unit.equals("f")) { // if given unit is fahrenheit
      converted_temp = celsius(just_temp); // then convert to celsius
      return String.format("%s is the same as %.1f C.%n", temp, converted_temp);
    } else if (unit.equals("C") || unit.equals("c")){ // if given unit is celsius
      converted_temp = fahrenheit(just_temp); // then convert to fahrenheit
      return String.format("%s is the same as %.1f F.%n", temp, converted_temp);
    } else {
      return "Please enter a unit (C or F).";
    }
  }

  public static String[] splitInput(String input){
    return input.split("\\s+"); // break up by whitespace
  }

  // converts a temperature in fahrenheit to celsius
  public static float celsius(float temp_fahr){
    return 5.0f / 9.0f * (temp_fahr - 32);
  } // end celsius

  // converts a temperature in celsius to fahrenheit
  public static float fahrenheit(float temp_celsius){
    return ((9.0f / 5.0f) * temp_celsius) + 32;
  } // end fahrenheit
} // end App