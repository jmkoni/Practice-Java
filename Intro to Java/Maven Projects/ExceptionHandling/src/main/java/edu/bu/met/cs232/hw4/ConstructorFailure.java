package edu.bu.met.cs232.hw4;

/**
 * ConstructorFailure
 * Created by Jennifer Konikowski 3/9/16
 *
 * A program that shows a constructor passing information about constructor failure to
 * an exception handler. Define class SomeClass, which throws an Exception in the
 * constructor. Your program should try to create an object of type SomeClass and catch
 * the exception that’s thrown from the constructor.
 */
public class ConstructorFailure
{
    public static void main( String[] args )
    {
        try{
            SomeClass test = new SomeClass();
        } catch (ExceptionA exception) {
            exception.printStackTrace();
        }
    }
}
