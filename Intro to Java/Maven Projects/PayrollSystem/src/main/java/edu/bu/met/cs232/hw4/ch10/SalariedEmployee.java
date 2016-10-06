package edu.bu.met.cs232.hw4.ch10;

/**
 * SalariedEmployee
 * 9.15
 * Created by jmkoni on 2/27/16.
 *
 * Class Salaried extends Employee and represents an instance of an employee who
 * has a weekly salary. Assuming weekly payroll since that is what makes sens with the
 * other classes.
 */
public class SalariedEmployee extends Employee {
  private double weeklySalary;
  public SalariedEmployee(String firstName, String lastName,
                          String socialSecurityNumber, int month, int day, int year,
                          double weeklySalary)
  {
    super(firstName, lastName, socialSecurityNumber, month, day, year);
    // implicit call to Object constructor occurs here
    // if grossSales is invalid throw exception
    if (weeklySalary < 0.0){
      throw new IllegalArgumentException("Weekly Salary must be >= 0.0");
    }
    this.weeklySalary = weeklySalary;
  } // end constructor

  // set weekly salary
  public void setWeeklySalary(double weeklySalary)
  {
    if (weeklySalary < 0.0) {
      throw new IllegalArgumentException("Weekly salary must be >= 0.");
    }
    this.weeklySalary = weeklySalary;
  }

  // return weekly salary
  public double getWeeklySalary()
  {
    return weeklySalary;
  }

  // calculate earnings for month
  @Override
  public double earnings()
  {
    return getWeeklySalary();
  }

  // calculate earnings; implement interface Payable method that was
  // abstract in superclass Employee
//  @Override
  public double getPaymentAmount()
  {
    return getWeeklySalary();
  }

  // return String representation of SalariedEmployee object
  @Override
  public String toString()
  {
    return String.format("%s %s%s: $%,.2f%n", "salaried",
        super.toString(), "weekly salary", getWeeklySalary());
  }
}