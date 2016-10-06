package edu.bu.met.cs232.hw4.ch10;

/**
 * BasePlusCommissionEmployee
 * Created by jmkoni on 3/4/16.
 *
 * extends CommissionEmployee, which extends Employee, which implements Payable
 *
 * This class represents an employee who works on commission, but also receives a base
 * salary.
 */
// Fig. 10.8: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee.
public class BasePlusCommissionEmployee extends CommissionEmployee {
  private double baseSalary; // base salary per week

  // constructor
  public BasePlusCommissionEmployee(String firstName, String lastName, String
      socialSecurityNumber, int month, int day, int year, double grossSales, double
      commissionRate, double baseSalary) {
    super(firstName, lastName, socialSecurityNumber, month, day, year, grossSales,
        commissionRate);
    if (baseSalary < 0.0) { // validate baseSalary
      throw new IllegalArgumentException("Base salary must be >= 0.0");
    }
    this.baseSalary = baseSalary;
  }

  // set base salary
  public void setBaseSalary(double baseSalary) {
    if (baseSalary < 0.0) { // validate baseSalary
      throw new IllegalArgumentException("Base salary must be >= 0.0");
    }
    this.baseSalary = baseSalary;
  }

  // return base salary
  public double getBaseSalary() {
    return baseSalary;
  }

  // calculate earnings; override method earnings in CommissionEmployee
  @Override
  public double earnings()
  {
    return getBaseSalary() + super.earnings();
  }

  // return String representation of BasePlusCommissionEmployee object
  @Override
  public String toString() {
    return String.format("%s %s%s: $%,.2f%n", "base-salaried", super.toString(), "base" +
        " " +
        "salary", getBaseSalary());
  }
  // if I wasn't using earnings in CommissionEmployee as the return value for
  // getPaymentAmount, I would be implementing getPaymentAmount here. As is, it grabs
  // the values from earnings, which is correctly set.
} // end class BasePlusCommissionEmployee