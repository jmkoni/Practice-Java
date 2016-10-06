package edu.bu.met.cs342;

import java.util.Scanner;

/**
 * The Quadratic Java application creates, analyzes, and prints out quadratic equations
 * in a human readable format.
 * @author Jennifer Konikowski (jmkoni@bu.edu)
 */
public class Quadratic {
  private int a;
  private int b;
  private int c;

  /**
   * main method for testing Quadratic class
   * @param args
   * @postcondition
   *   Three Quadratic objects are created and displayed. Q1 and Q2 are summed and Q3
   *   is scaled.
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Quadratic q1 = Quadratic.createNewQuad(input);
    System.out.println("Equation 1:");
    q1.displayQuadratic();
    System.out.println("-------");
    Quadratic q2 = Quadratic.createNewQuad(input);
    System.out.println("Equation 2:");
    q2.displayQuadratic();
    System.out.println("-------");
    Quadratic q3 = Quadratic.createNewQuad(input);
    System.out.println("Equation 3:");
    q3.displayQuadratic();
    System.out.println("-------");
    Quadratic sumQ = q1.sum(q2);
    System.out.println("Sum of 1 and 2:");
    sumQ.displayQuadratic();
    System.out.println("-------");
    System.out.print("Enter a value for r to scale the equation: ");
    int r = input.nextInt();
    q3.scale(r);
    System.out.println(q3.getA());
    System.out.printf("Equation 3 scaled by %d:\n", r);
    q3.displayQuadratic();
    input.close();
  }

  /**
   * Construct a Quadratic with specified coefficients
   *
   * @param a
   *   the coefficient of x2
   * @param b
   *   the coefficient of x
   * @param c
   *   the constant coefficient
   * @postcondition
   *   This Quadratic has been initialized with the given coefficients.
   */
  public Quadratic(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * Class method. Outputs prompt for user to enter coefficients, then take those coefficients and returns a new Quadratic object.
   *
   * @param input
   *   Scanner object to get input from user
   * @return
   *   A Quadratic object that matches the coefficients entered by the user.
   * @throws IndexOutOfBoundsException
   *   if the number of coefficients entered is not equal to three.
   */
  public static Quadratic createNewQuad(Scanner input) throws IndexOutOfBoundsException {
    System.out.print("Enter three coefficients a, b, and c, separated by a space(s): ");
    String allCoeff = input.nextLine();
    String[] splitCoeff = allCoeff.split(" ");
    if (splitCoeff.length != 3) {
      throw new IndexOutOfBoundsException("You have entered " + splitCoeff.length + " " +
          "coefficients. Please enter only 3.");
    }
    int a = Integer.parseInt(splitCoeff[0]);
    int b = Integer.parseInt(splitCoeff[1]);
    int c = Integer.parseInt(splitCoeff[2]);
    Quadratic q = new Quadratic(a, b, c);
    return q;
  }

  /**
   * Prints out the Quadratic objects as a human would expect to read it.
   *
   * @postcondition
   *  The quadratic formula should be printed out to the screen.
   */
  public void displayQuadratic(){
    String x2 = displayX2(this.a);
    String x1 = displayX(this.b, this.a);
    String x0 = displayX0(this.c, this.b, this.a);
    String statement = x2 + x1 + x0;
    System.out.println(statement.trim());
  }

  /**
   * Adds Quadratic q to the Quadratic object that called it.
   *
   * @param q
   *  Quadratic object to be added to original Quadratic object
   * @return
   *  Quadratic object where each of the coefficients has been added to the
   *  matching coefficient. Ex. (a1 + a2)x2 + (b1 + b2)x + (c1 + c2)
   */
  public Quadratic sum(Quadratic q){
    int a3 = this.a + q.getA();
    int b3 = this.b + q.getB();
    int c3 = this.c + q.getC();
    Quadratic q3 = new Quadratic(a3, b3, c3);
    return q3;
  }

  /**
   * Evaluates Quadratic object by solving for 0. Ex: ax2 + bx + c = 0
   *
   * @return
   *   An array of two doubles.
   * @throws ArithmeticException
   *   if all coefficients but C are zero. Since zero cannot be equal to a constant,
   *   this causes the equation to not be able to be evaluated.
   */
  public double[] evaluateQuadratic() throws ArithmeticException {
    double answer;
    if (this.a == 0){
      if (this.b == 0){
        if (this.c != 0) {
          throw new ArithmeticException("Constant cannot be equal to zero.");
        } else {
          answer = 0.0;
        }
      } else {
        answer = -(this.c)/this.b;
      }
      return new double[] {answer, answer};
    }
    double square = Math.sqrt((this.b * this.b) - (4 * this.a * this.c));
    double negativeNum = (-this.b - square) / (2 * this.a);
    double positiveNum = (this.b - square) / (2 * this.a);
    return new double[] {negativeNum, positiveNum};
  }

  /**
   * Scales (multiplies coefficient A) by given scaleNum.
   *
   * @param scaleNum
   *   int to scale the equation by
   * @postcondition
   *   Quadratic object is now scaled by scaleNum
   */
  public void scale(int scaleNum){
    this.a = a * scaleNum;
  }

  // getters and setters

  /**
   * Retrieve private instance variable a
   *
   * @return
   *   integer value of given coefficient
   */
  public int getA(){
    return a;
  }


  /**
   * Retrieve private instance variable b
   *
   * @return
   *   integer value of given coefficient
   */
  public int getB(){
    return b;
  }


  /**
   * Retrieve private instance variable c
   *
   * @return
   *   integer value of given coefficient
   */
  public int getC(){
    return c;
  }

  /**
   * Set private instance variable a
   *
   * @param a
   *   updated value of coefficient
   * @postcondition
   *   The Quadratic object has been updated with the given coefficient.
   */
  public void setA(int a){
    this.a = a;
  }

  /**
   * Set private instance variable b
   *
   * @param b
   *   updated value of coefficient
   * @postcondition
   *   The Quadratic object has been updated with the given coefficient.
   */
  public void setB(int b){
    this.b = b;
  }

  /**
   * Set private instance variable c
   *
   * @param c
   *   updated value of coefficient
   * @postcondition
   *   The Quadratic object has been updated with the given coefficient.
   */
  public void setC(int c){
    this.c = c;
  }

  /**
   * Returns a string representation of ax2
   *
   * @param a
   *   value of coefficient a
   * @return
   *   	a string representation of ax2, ex: 3x^2
   */
  private String displayX2(int a){
    if (a == 0){
      return "";
    } else {
      return a + "x^2";
    }
  }

  /**
   * Returns a string representation of ax
   *
   * @param b
   *   value of coefficient B
   * @param a
   *   value of coefficient A
   * @return
   *   a string representation of bx
   * @apiNote
   *   If a is not equal to zero, make sure there is “ + “ or “ - “ in front of it,
   *   with spaces on either side.
   */
  private String displayX(int b, int a){
    if (b == 0){
      return "";
    } else if (a == 0){
      return b + "x";
    } else {
      if (b > 0){
        return " + " + b + "x";
      } else {
        return " - " + Math.abs(b) + "x";
      }
    }
  }

  /**
   * Returns a string representation of c
   *
   * @param c
   *   value of coefficient C
   * @param b
   *   value of coefficient B
   * @param a
   *   value of coefficient A
   * @return
   *   a string representation of c
   * @apiNote
   *   If a and b are not equal to zero, make sure there is a “ + “ or “ - “ in front
   *   of it, with spaces on either side.
   */
  private String displayX0(int c, int b, int a){
    if (c == 0){
      return "";
    } else if ((a == 0) && (b == 0)) {
      return String.valueOf(c);
    } else {
      if ( c < 0){
        return " - " + Math.abs(c);
      } else {
        return " + " + c;
      }
    }
  }
}
