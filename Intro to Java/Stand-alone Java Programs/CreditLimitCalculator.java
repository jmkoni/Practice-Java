package edu.bu.met.cs232;

/**
 * CreditLimitCalculator.java
 * 4.18
 * Created by Jennifer Konikowski on 2/7/16.
 *
 * This application determines whether any of several department-store customers have exceeded their credit limit.
 * For each customer, the following facts are available:
 *   a) account number
 *   b) balance at the beginning of the month
 *   c) total of all items charged by the customer this month
 *   d) total of all credits applied to the customer's account this month
 *   e) allowed credit limit
 * This program inputs all these facts as integers, calculates the new balance (= beginning balance + charges - credits),
 * display the new balance and determine whether the new balance exceeds the customer's credit limit. For the customers
 * whose credit limit is exceeded, the program should display "Credit limit exceeded."
 */
import java.util.Scanner;
public class CreditLimitCalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int accountNumber, balance, chargedTotal, creditsTotal, allowedLimit, newBalance;
        while (true) {
            System.out.print("Enter account number (0 to quit): "); //prompt
            accountNumber = input.nextInt();
            if (accountNumber == 0) {
                // break out of look if account number is 0
                break;
            }
            System.out.print("Enter balance: "); //prompt
            balance = input.nextInt();
            System.out.print("Enter total charged by customer: ");
            chargedTotal = input.nextInt();
            System.out.print("Enter total of all credits applied to customer's account: ");
            creditsTotal = input.nextInt();
            System.out.print("Enter allowed credit limit: ");
            allowedLimit = input.nextInt();
            newBalance = balance + chargedTotal - creditsTotal; // calculate new balance
            System.out.printf("Updated Balance: $%d%n", newBalance);
            System.out.println("");
            if (newBalance > allowedLimit) {
                // if the new balance is greater than allowed limit...
                System.out.println("Credit limit exceeded.");
            }
        }
    }
}
