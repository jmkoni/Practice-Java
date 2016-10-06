package edu.bu.met.cs232;

/**
 * SalesCommissionCalculator.java
 * 4.19
 * Created by Jennifer Konikowski on 2/7/16.
 *
 * A large company pays its salespeople on a commission basis. The salespeople receive
 * $200 per week plus 9% of their gross sales for that week. Here's a list of items:
 *    Item   Value
 *    1      239.99
 *    2      129.75
 *    3       99.95
 *    4      350.89
 * This application inputs one salesperson's items sold for last week and calculates and displays the
 * person's earnings. There is no limit to the number of items sold.
 */
import java.util.Hashtable;
import java.util.Scanner;

public class SalesCommissionCalculator {
    public static void main(String[] args) {
        // create a hash table of the list of items to map the id to price
        Hashtable<Integer, Double> itemList = new Hashtable<Integer, Double>();
        itemList.put(1, 239.99);
        itemList.put(2, 129.75);
        itemList.put(3, 99.95);
        itemList.put(4, 350.89);

        Scanner input = new Scanner(System.in);
        int itemNumber;
        double earnings = 200.00; // initialize earnings with base weekly pay
        while (true) {
            System.out.print("Enter item number sold by person (0 to quit): "); //prompt
            itemNumber = input.nextInt();
            if (itemNumber == 0){
                // break out of loop if acount number is zero
                break;
            }
            earnings += 0.09 * itemList.get(itemNumber); // calculate earnings from commission
            System.out.printf("Total earnings for the week: $%.2f%n%n", earnings); // print out current earnings
        }

    }
}
