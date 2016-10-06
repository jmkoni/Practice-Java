package edu.bu.met.cs232.hw3.ch8;

/**
 * App to Test SavingsAccount
 * 8.6
 * Created by Jennifer Konikowski on 2/21/2016
 *
 * Create class SavingsAccount. Use a static variable annualInterestRate to store the
 * annual interest rate for all account holders. Each object of the class contains a
 * private instance variable savingsBalance indicating the amount the saver currently
 * has on deposit. Provide method calculateMonthlyInterest to calculate the monthly
 * interest by multiplying the savingsBalance by annualInterestRate divided by 12—this
 * interest should be added to savingsBalance. Provide a static method
 * modifyInterestRate that sets the annualInterestRate to a new value. Write a program
 * to test class SavingsAccount. Instantiate two savingsAccount objects, saver1 and
 * saver2, with balances of $2000.00 and $3000.00, respectively. Set annualInterestRate
 * to 4%, then calculate the monthly interest for each of 12 months and print the new
 * balances for both savers. Next, set the annualInterestRate to 5%, calculate the next
 * month’s interest and print the new balances for both savers.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      SavingsAccount saver1 = new SavingsAccount(2000.00f);
      SavingsAccount saver2 = new SavingsAccount(3000.00f);
      System.out.printf("Initial balance for saver1: $%.2f.%n", saver1.getSavingsBalance
          ());
      System.out.printf("Initial balance for saver2: $%.2f.%n", saver2.getSavingsBalance
          ());
      System.out.printf("Annual interest rate: %.2f", SavingsAccount
          .getAnnualInterestRate());
      System.out.print("%.\n");
      SavingsAccount.modifyInterestRate(0.04f);
      for (int i = 0; i < 12; i++){
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
      }
      System.out.printf("Balance at end of year for saver1: $%.2f.%n", saver1
          .getSavingsBalance());
      System.out.printf("Balance at end of year for saver2: $%.2f.%n", saver2
          .getSavingsBalance());
      SavingsAccount.modifyInterestRate(0.05f);
      saver1.calculateMonthlyInterest();
      saver2.calculateMonthlyInterest();
      System.out.printf("Annual interest rate: %.2f", SavingsAccount
          .getAnnualInterestRate());
      System.out.print("%.\n");
      System.out.printf("Balance at end of next month for saver1: $%.2f.%n", saver1
          .getSavingsBalance());
      System.out.printf("Balance at end of next month for saver2: $%.2f.%n", saver2
          .getSavingsBalance());
    }
}
