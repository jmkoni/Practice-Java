package edu.bu.met.cs232.hw3.ch6;

/**
 * edu.bu.met.cs232.CircleArea
 * 6.20
 * Created by Jennifer Konikowski on 2/15/16.
 *
 * This application prompts the user for the radius of a circle and uses a method
 * called circleArea to calculate the area of the circle.
 */

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter radius of the circle: ");
    int circle_radius = input.nextInt(); // read in int for radius
    float circle_area = circleArea(circle_radius); // determine area
    System.out.printf("Area of the circle is %.5f.%n", circle_area);
    input.close();
  } // end main

  public static float circleArea(int radius){
    return (float) (radius * radius * Math.PI); // radius = pi * r^2
  } // end circleArea
} // end App