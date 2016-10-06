package edu.bu.met.cs232.hw3.ch8;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * SavingsAccount
 * 8.6
 * Created by Jennifer Konikowski on 2/21/16.
 *
 * This class represents a SavingsAccount. It has an instance variable, savingsBalance,
 * that is set in the initializer and retrieved by getSavingsBalance. It also has a
 * class variable, annualInterestRate, that is set by modifyInterestRate and retrieved
 * by getAnnualInterestRate. The function calculateMonthlyInterest calculates the
 * interest for a single acount by multiplying the savingsBalance by annualInterestRate
 * and dividing by 12. This function also adds the monthly interest to savingsBalance.
 */
public class SavingsAccount {
  private static BigDecimal annualInterestRate;
  private BigDecimal savingsBalance;

  public SavingsAccount(){
    this(0.0);
  }

  public SavingsAccount(double balance){
    this.savingsBalance = BigDecimal.valueOf(balance);
  }

  public BigDecimal getSavingsBalance(){
    return savingsBalance;
  }

  public BigDecimal calculateMonthlyInterest(){
    BigDecimal monthlyInterest = savingsBalance.multiply(annualInterestRate).divide
        (BigDecimal.valueOf(12.0), 2, RoundingMode.HALF_EVEN); // round to nearest
    // neighbor
    savingsBalance = savingsBalance.add(monthlyInterest);
    return monthlyInterest;
  }

  public static void modifyInterestRate(double newRate){
    annualInterestRate = BigDecimal.valueOf(newRate);
  }

  public static BigDecimal getAnnualInterestRate(){
    return annualInterestRate;
  }
}
