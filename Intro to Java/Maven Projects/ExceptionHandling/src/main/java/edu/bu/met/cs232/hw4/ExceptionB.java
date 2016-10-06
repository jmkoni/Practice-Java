package edu.bu.met.cs232.hw4;

/**
 * ExceptionB
 * Created by jmkoni on 3/9/16.
 *
 * This class inherits from ExceptionA and returns "Too many bears at this party."
 *
 */
public class ExceptionB extends ExceptionA {
  public ExceptionB()
  {
    this("bears");
  }

  public ExceptionB(String thing)
  {
    super(thing);
  }
}
