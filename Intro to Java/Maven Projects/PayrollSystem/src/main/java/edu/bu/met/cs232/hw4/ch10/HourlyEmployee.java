package edu.bu.met.cs232.hw4.ch10;

/**
 * HourlyEmployee
 * Created by jmkoni on 3/4/16.
 *
 * This class represents an employee who is paid with an hourly wage. If the employee
 * works over 40 hours, they get paid time and a half.
 */
// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee.

public class HourlyEmployee extends Employee {
  private double wage; // wage per hour
  private double hours; // hours worked for week

  // constructor
  public HourlyEmployee(String firstName, String lastName, String
      socialSecurityNumber, int month, int day, int year, double wage, double
                            hours) {
    super(firstName, lastName, socialSecurityNumber, month, day, year);
    if (wage < 0.0) // validate wage
      throw new IllegalArgumentException(
          "Hourly wage must be >= 0.0");

    if ((hours < 0.0) || (hours > 168.0)) // validate hours
      throw new IllegalArgumentException(
          "Hours worked must be >= 0.0 and <= 168.0");

    this.wage = wage;
    this.hours = hours;
  }

  // set wage
  public void setWage(double wage)
  {
    if (wage < 0.0) // validate wage
      throw new IllegalArgumentException(
          "Hourly wage must be >= 0.0");

    this.wage = wage;
  }

  // return wage
  public double getWage()
  {
    return wage;
  }

  // set hours worked
  public void setHours(double hours)
  {
    if ((hours < 0.0) || (hours > 168.0)) // validate hours
      throw new IllegalArgumentException(
          "Hours worked must be >= 0.0 and <= 168.0");

    this.hours = hours;
  }

  // return hours worked
  public double getHours()
  {
    return hours;
  }

  // calculate earnings; override abstract method earnings in Employee
  @Override
  public double earnings()
  {
    if (getHours() <= 40) // no overtime
      return getWage() * getHours();
    else
      return (40 * getWage()) + ((getHours() - 40) * getWage() * 1.5);
  }

  // return String representation of HourlyEmployee object
  @Override
  public String toString()
  {
    return String.format("hourly %s%s: $%,.2f%n%s: %,.1f%n",
        super.toString(), "hourly wage", getWage(),
        "hours worked", getHours());
  }

  public double getPaymentAmount(){
    return earnings();
  }
} // end class HourlyEmployee