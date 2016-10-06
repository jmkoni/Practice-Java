package edu.bu.met.cs232.hw4;

/**
 * CatchingExceptionsWithSuperclasses
 * Created by jmkoni on 3/9/16.
 *
 * Use inheritance to create an exception superclass (called ExceptionA) and exception
 * subclasses ExceptionB and ExceptionC, where ExceptionB inherits from ExceptionA and
 * ExceptionC inherits from ExceptionB. Write a program to demonstrate that the catch
 * block for type ExceptionA catches exceptions of types ExceptionB and ExceptionC.
 */
// Fig. 11.7: CatchingExceptionsWithSuperclasses.java
// Chained exceptions.
public class CatchingExceptionsWithSuperclasses
{
  public static void main(String[] args)
  {
    try
    {
      method1();
    }
    catch (ExceptionA exception) // exceptions thrown from method1
    {
      exception.printStackTrace();
    }
  }
  // call method2; throw exceptions back to main
  public static void method1() throws ExceptionA
  {
    try
    {
      method2();
    } // end try
    catch (ExceptionA exception) // exception thrown from method2
    {
      throw new ExceptionA();
    }
  }
  // call method3; throw exceptions back to method1
  public static void method2() throws ExceptionB
  {
    try
    {
      method3();
    }
    catch (ExceptionB exception) // exception thrown from method3
    {
      throw new ExceptionB();
    }
  }
  // throw Exception back to method2
  public static void method3() throws ExceptionC
  {
    throw new ExceptionC();
  }
} // end class UsingChainedException
