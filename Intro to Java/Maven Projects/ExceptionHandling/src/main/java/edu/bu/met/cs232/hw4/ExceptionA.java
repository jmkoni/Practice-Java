package edu.bu.met.cs232.hw4;

/**
 * ExceptionA
 * Created by jmkoni on 3/9/16.
 *
 * This exception inherits from the main Exception class and returns "Too many ponies
 * at this party."
 */
public class ExceptionA extends Exception
{

  public ExceptionA()
  {
    this("ponies");
  }

  public ExceptionA(String thing)
  {
    super("Too many " + thing + " at this party.");
  }
}
