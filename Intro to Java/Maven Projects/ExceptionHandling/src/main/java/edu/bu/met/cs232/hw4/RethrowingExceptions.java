package edu.bu.met.cs232.hw4;

/**
 * RethrowingExceptions
 * Created by jmkoni on 3/9/16.
 *
 * A program that illustrates rethrowing an exception. Define methods someMethod and
 * someMethod2. Method someMethod2 should initially throw an exception. Method
 * someMethod should call someMethod2, catch the exception and rethrow it. Call
 * someMethod from method main, and catch the rethrown exception. Print the stack trace
 * of this exception.
 */
public class RethrowingExceptions {
  public static void main(String[] args) {
    try{
      someMethod();
    } catch (ExceptionC exception) {
      exception.printStackTrace();
    }
  }

  private static void someMethod() throws ExceptionC {
    try {
      someMethod2();
    } catch (ExceptionC exception) {
      throw exception;
    }
  }

  private static void someMethod2() throws ExceptionC{
    throw new ExceptionC();
  }
}
