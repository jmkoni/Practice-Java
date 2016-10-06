package edu.bu.met.cs232.hw4.ch10;

import org.joda.time.DateTime;

/**
 * Created by jmkoni on 2/27/16.
 */
// Fig. 10.4: Employee.java
// Employee abstract superclass.

public abstract class Employee implements Payable {
  private final String firstName;
  private final String lastName;
  private final String socialSecurityNumber;
  private final DateTime birthDate;

  // constructor
  public Employee(String firstName, String lastName, String socialSecurityNumber, int
      month, int day, int year){
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
    this.birthDate = new DateTime(year, month, day, 0, 0);
  }
  // return first name
  public String getFirstName(){
    return firstName;
  }

  // return last name
  public String getLastName(){
    return lastName;
  }
  // return social security number
  public String getSocialSecurityNumber(){
    return socialSecurityNumber;
  }

  public DateTime getBirthDate(){
    return birthDate;
  }

  // return String representation of Employee object
  @Override
  public String toString(){
    return String.format("employee: %s %s%nsocial security number: %s%n", getFirstName(),
        getLastName(), getSocialSecurityNumber());
  }
  // abstract method must be overridden by concrete subclasses
  public abstract double earnings(); // no implementation here

  // Note: We do not implement Payable method getPaymentAmount here so
  // this class must be declared abstract to avoid a compilation error.
} // end abstract class Employee