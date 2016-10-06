package edu.bu.met.cs232.hw3.ch5;

/**
 * TrianglePrinting
 * 5.15
 * Created by Jennifer Konikowski on 2/14/16.
 *
 * Write an application that displays the following patterns separately,
 * one below the other. Use for loops to generate the patterns.
 * Triangle A
 * *
 * **
 * ***
 * ****
 * *****
 * ******
 * *******
 * ********
 * *********
 * **********
 *
 * Triangle B
 * **********
 * *********
 * ********
 * *******
 * ******
 * *****
 * ****
 * ***
 * **
 * *
 *
 * Triangle C
 * **********
 *  *********
 *   ********
 *    *******
 *     ******
 *      *****
 *       ****
 *        ***
 *         **
 *          *
 *
 * Triangle D
 *          *
 *         **
 *        ***
 *       ****
 *      *****
 *     ******
 *    *******
 *   ********
 *  *********
 * **********
 *
 * In making this testable, I ended up really DRYing up my code, which was awesome.
 */
public class App {
  public static void main(String[] args) {
    System.out.println("Triangle A");
    goingUpTriangle(10, "left");
    System.out.println("");
    System.out.println("Triangle B");
    goingDownTriangle(10, "left");
    System.out.println("");
    System.out.println("Triangle C");
    goingUpTriangle(10, "right");
    System.out.println("");
    System.out.println("Triangle D");
    goingDownTriangle(10, "right");
    System.out.println("");
  }

  // make the triangles where the first item (either " " or "*") is increasing
  public static void goingUpTriangle(int numRows, String direction){
    for(int i=1; i <= numRows; i++){
      triangleContent(i, numRows, direction);
    }
  }

  // make the triangle where the first item (either " " or "*" is decreasing
  public static void goingDownTriangle(int numRows, String direction){
    for(int i=numRows; i >= 1; i--) {
      triangleContent(i, numRows, direction);
    }
  }

  // loop through and print out the spaces and asterisks
  public static void triangleContent(int i, int numRows, String direction){
    if(direction.equals("right")) {
      for(int j=1; j < i; j++){
        System.out.print(" ");
      }
      // after spaces, add asterisks
      for(int k=numRows; k >= i; k--){
        System.out.print("*");
      }
    } else {
      for(int j=1; j <= i; j++){
        System.out.print("*");
      }
    }
    System.out.println();
  }
}