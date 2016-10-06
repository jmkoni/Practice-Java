package edu.bu.met.cs232.hw3.ch8;

/**
 * App to test Rectangle Class
 *
 * Create a class Rectangle with attributes length and width, each of which defaults to
 * 1. Provide methods that calculate the rectangle’s perimeter and area. It has set and
 * get methods for both length and width. The set methods should verify that length and
 * width are each floating-point numbers larger than 0.0 and less than 20.0. Write a
 * program to test class Rectangle.
 */
public class App 
{
    public static void main( String[] args )
    {
      Rectangle basic = new Rectangle();
      System.out.printf("Width of basic rectangle is %.1f.%n", basic.getWidth());
      System.out.printf("Length of basic rectangle is %.1f.%n", basic.getLength());
      System.out.printf("Area of basic rectangle is %.1f.%n", basic.area());
      System.out.printf("Perimeter of basic rectangle is %.1f.%n", basic.perimeter());

      System.out.println("Attempt to make width and length a negative value.");
      basic.setWidth(-1.00f);
      basic.setLength(-2.00f);
      System.out.printf("Width of basic rectangle is %.1f.%n", basic.getWidth());
      System.out.printf("Length of basic rectangle is %.1f.%n", basic.getLength());

      System.out.println("Create a rectangle with length and width of 10");
      Rectangle large = new Rectangle(10f, 10f);
      System.out.printf("Width of large rectangle is %.1f.%n", large.getWidth());
      System.out.printf("Length of large rectangle is %.1f.%n", large.getLength());
      System.out.printf("Area of large rectangle is %.1f.%n", large.area());
      System.out.printf("Perimeter of large rectangle is %.1f.%n", large.perimeter());
    }
}
