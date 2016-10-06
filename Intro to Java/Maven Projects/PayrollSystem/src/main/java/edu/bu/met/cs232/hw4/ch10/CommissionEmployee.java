package edu.bu.met.cs232.hw4.ch10;

/**
 * CommissionEmployee
 * Created by jmkoni on 3/4/16.
 *
 * extends Employee which in turn implements Payable
 *
 * This class represents an employee who works strictly on commission.
 */
// Fig. 10.7: CommissionEmployee.java
// CommissionEmployee class extends Employee.

public class CommissionEmployee extends Employee {
  private double grossSales; // gross weekly sales
  private double commissionRate; // commission percentage

  // constructor
  public CommissionEmployee(String firstName, String lastName, String
      socialSecurityNumber, int month, int day, int year, double grossSales, double
      commissionRate) {
    super(firstName, lastName, socialSecurityNumber, month, day, year);
    if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
      throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
    }

    if (grossSales < 0.0) {// validate
      throw new IllegalArgumentException("Gross sales must be >= 0.0");
    }

    this.grossSales = grossSales;
    this.commissionRate = commissionRate;
  }

  // set gross sales amount
  public void setGrossSales(double grossSales) {
    if (grossSales < 0.0) {// validate
      throw new IllegalArgumentException("Gross sales must be >= 0.0");
    }
    this.grossSales = grossSales;
  }

  // return gross sales amount
  public double getGrossSales() {
    return grossSales;
  }

  // set commission rate
  public void setCommissionRate(double commissionRate) {
    if (commissionRate <= 0.0 || commissionRate >= 1.0) {
      throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
    }
    this.commissionRate = commissionRate;
  }

  // return commission rate
  public double getCommissionRate() {
    return commissionRate;
  }

  // calculate earnings; override abstract method earnings in Employee
  @Override
  public double earnings() {
    return getCommissionRate() * getGrossSales();
  }

  // return String representation of CommissionEmployee object
  @Override
  public String toString()
  {
    return String.format("%s %s%s: $%,.2f%n%s: %.2f%n", "commission", super
        .toString(), "gross sales", getGrossSales(), "commission rate",
        getCommissionRate());
  }

  public double getPaymentAmount(){
    return earnings();
  }
} // end class CommissionEmployee