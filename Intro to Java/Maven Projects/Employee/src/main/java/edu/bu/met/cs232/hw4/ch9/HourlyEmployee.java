package edu.bu.met.cs232.hw4.ch9;

/**
 * HourlyEmployee
 * 9.15
 * Created by jmkoni on 2/27/16.
 *
 * Class HourlyEmployee extends Employee and represents an instance of an employee who
 * has an hourly wage. Hourly employees get time and a half for hours worked over 40.
 * This instance assumes same number of hours worked per week to calculate yearly
 * earnings.
 */
public class HourlyEmployee extends Employee {
  private double hourlyWage;
  private double hoursWorked;
  public HourlyEmployee(String firstName, String lastName,
                        String socialSecurityNumber, double hourlyWage, double hoursWorked)
  {
    super(firstName, lastName, socialSecurityNumber);
    if (hourlyWage < 0.0){
      throw new IllegalArgumentException("Hourly wage must be >= 0.0");
    }
    this.hourlyWage = hourlyWage;
    this.hoursWorked = hoursWorked;
  } // end constructor


  // set hours worked
  public void setHoursWorked(double hoursWorked)
  {
    if (hoursWorked < 0.0) {
      throw new IllegalArgumentException("Hours worked must be >= 0.");
    }
    this.hoursWorked = hoursWorked;
  }

  // return hours worked
  public double getHoursWorked()
  {
    return hoursWorked;
  }

  // return hourly wage
  public double getHourlyWage(){
    return hourlyWage;
  }

  // set hourly wage
  public void setHourlyWage(double hourlyWage)
  {
    if (hourlyWage < 0.0) {
      throw new IllegalArgumentException("Hourly wage must be >= 0.");
    }
    this.hourlyWage = hourlyWage;
  }

  // calculate earnings for year
  public double earnings()
  {
    double extraHours = 0.0;
    double regularHours = 40.0;
    if (getHoursWorked() > 40){
      extraHours = getHoursWorked() - 40.0;
    } else {
      regularHours = getHoursWorked();
    }
    double totalPerWeek = (regularHours * getHourlyWage()) + (extraHours * 1.5 *
        getHourlyWage());
    return totalPerWeek * 52;
  }

  // return String representation of Hourly employees object
  @Override
  public String toString()
  {
    return String.format("%s %s%s: %.2f%n%s: %.1f%n", "hourly",
        super.toString(), "hourly wage", getHourlyWage(), "hours worked",
        getHoursWorked());
  }
}
