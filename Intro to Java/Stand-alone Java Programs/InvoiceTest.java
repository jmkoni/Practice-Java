package edu.bu.met.cs232;

import java.util.Scanner;

/**
 * InvoiceTest.java
 * 3.12
 * Created by Jennifer Konikowski on 2/6/16.
 *
 * Test class for Invoice.java
 */
public class InvoiceTest {
    public static void main(String[] args) {
        Invoice invoice1 = new Invoice("1235F", "it's a pony!", 5, -7.5);
        Invoice invoice2 = new Invoice("J8J2", "DOUBLE RAINBOW", 2, 800.00);

        // display initial invoices:
        System.out.printf("Invoice1: %s - %s - %d - $%.2f%nTotal: $%.2f%n%n",
                invoice1.getPartNumber(),
                invoice1.getPartDescription(),
                invoice1.getItemQuantity(),
                invoice1.getItemPrice(),
                invoice1.getInvoiceAmount());
        System.out.printf("Invoice2: %s - %s - %d - $%.2f%nTotal: $%.2f%n%n",
                invoice2.getPartNumber(),
                invoice2.getPartDescription(),
                invoice2.getItemQuantity(),
                invoice2.getItemPrice(),
                invoice2.getInvoiceAmount());

        // create a scanner object
        Scanner input = new Scanner(System.in);

        // TEST PART NUMBER
        System.out.print("Enter part number for Invoice 1: "); //prompt
        String partNumber = input.nextLine(); // obtain user input
        System.out.printf("%nupdating part number for Invoice 1 to %s%n%n", partNumber);
        invoice1.setPartNumber(partNumber);

        // TEST PART DESCRIPTION
        System.out.print("Enter part description for Invoice 2: "); //prompt
        String partDescription = input.nextLine(); // obtain user input
        System.out.printf("%nupdating part description for Invoice 2 to %s%n%n", partDescription);
        invoice2.setPartDescription(partDescription);

        // TEST ITEM QUANTITY
        System.out.print("Enter item quantity for Invoice 1: "); //prompt
        int itemQuantity = input.nextInt(); // obtain user input
        System.out.printf("%nupdating item quantity for Invoice 1 to %d%n%n", itemQuantity);
        invoice1.setItemQuantity(itemQuantity);

        System.out.print("Enter item quantity for Invoice 2: "); //prompt
        itemQuantity = input.nextInt(); // obtain user input
        System.out.printf("%nupdating item quantity for Invoice 2 to %d%n%n", itemQuantity);
        invoice2.setItemQuantity(itemQuantity);

        // TEST ITEM PRICE
        System.out.print("Enter item price for Invoice 1: "); //prompt
        double itemPrice = input.nextDouble(); // obtain user input
        System.out.printf("%nupdating item price for Invoice 1 to %.2f%n%n", itemPrice);
        invoice1.setItemPrice(itemPrice);

        System.out.print("Enter item price for Invoice 2: "); //prompt
        itemPrice = input.nextDouble(); // obtain user input
        System.out.printf("%nupdating item quantity for Invoice 2 to %.2f%n%n", itemPrice);
        invoice2.setItemPrice(itemPrice);

        // display ending invoices:
        System.out.printf("Invoice1: %s - %s - %d - $%.2f%nTotal: $%.2f%n%n",
                invoice1.getPartNumber(),
                invoice1.getPartDescription(),
                invoice1.getItemQuantity(),
                invoice1.getItemPrice(),
                invoice1.getInvoiceAmount());
        System.out.printf("Invoice2: %s - %s - %d - $%.2f%nTotal: $%.2f%n%n",
                invoice2.getPartNumber(),
                invoice2.getPartDescription(),
                invoice2.getItemQuantity(),
                invoice2.getItemPrice(),
                invoice2.getInvoiceAmount());
    } // end main
} // end InvoiceTest
