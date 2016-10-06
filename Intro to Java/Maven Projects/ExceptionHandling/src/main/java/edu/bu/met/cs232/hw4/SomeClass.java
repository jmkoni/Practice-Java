package edu.bu.met.cs232.hw4;

/**
 * SomeClass
 * Created by jmkoni on 3/9/16.
 *
 * This class was created so show what happens when an error is thrown in the
 * constructor. I wasn't sure if I should add more... in a real life scenario, I would
 * be throwing an exception if a value is not correct (ex must be greater than 0, but
 * is passed as -1).
 */
public class SomeClass {
  public SomeClass() throws ExceptionA {
    throw new ExceptionA();
  }
}
