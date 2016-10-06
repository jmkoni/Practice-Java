package edu.bu.met.cs232.hw4;

/**
 * ExceptionC
 * Created by jmkoni on 3/9/16.
 *
 * This exception inherits from ExceptionB and throws "Too many cats at this party."
 *
 */
public class ExceptionC extends ExceptionB {
  public ExceptionC()
  {
    this("cats");
  }

  public ExceptionC(String thing)
  {
    super(thing);
  }
}
