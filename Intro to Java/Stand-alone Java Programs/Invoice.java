package edu.bu.met.cs232;

/**
 * Invoice.java
 * 3.12
 * Created by Jennifer Konikowski on 2/6/16.
 *
 * This is a class made for use by a hardware store to represent an invoice for an item sold.
 *
 * An invoice contains four pieces of information:
 *   * part number (type String)
 *   * part description (type String)
 *   * quantity of item being purchased (type int)
 *   * price per item (double)
 *
 * This class initializes all the variables and provides getters and setters for each.
 * getInvoiceAmount calculates the invoice amount by multiplying the quantity by the price per item, then returns a double
 * If the quantity is not positive, it should be zero
 * If the price per item is not positive, it should be 0.
 *
 * InvoiceTest.java tests this class.
 */
public class Invoice {
    private String partNumber;
    private String partDescription;
    private int itemQuantity;
    private double itemPrice;

    // Invoice constructor that receives four parameters
    public Invoice(String partNumber, String partDescription, int itemQuantity, double itemPrice) {
        this.partNumber = partNumber; // assign part number to instance variable
        this.partDescription = partDescription; // assign partDescription to instance variable

        // validate that the item quantity is positive
        if (itemQuantity > 0){
            this.itemQuantity = itemQuantity; // assign item quantity to instance variable
        }

        // validate that item price is positive
        if (itemPrice > 0){
            this.itemPrice = itemPrice; // assign itemPrice to instance variable
        }
    } // end Invoice

    // method that sets partNumber
    public void setPartNumber(String partNumber){
        this.partNumber = partNumber;
    }

    // method that returns partNumber
    public String getPartNumber() {
        return partNumber;
    }

    // method that sets partDescription
    public void setPartDescription(String partDescription){
        this.partDescription = partDescription;
    }

    // method that returns partDescription
    public String getPartDescription() {
        return partDescription;
    }

    //method that sets itemQuantity
    public void setItemQuantity(int itemQuantity){
        if (itemQuantity > 0){
            this.itemQuantity = itemQuantity;
        } else {
            System.out.println("Item quantity must be greater than zero.");
        }
    }

    // method that gets itemQuantity
    public int getItemQuantity() {
        return itemQuantity;
    }

    // method that sets itemPrice
    public void setItemPrice(double itemPrice){
        if (itemPrice > 0.0) {
            this.itemPrice = itemPrice;
        } else {
            System.out.println("Item price must be greater than $0.0.");
        }
    }

    // method that gets itemPrice
    public double getItemPrice() {
        return itemPrice;
    }

    public double getInvoiceAmount() {
        return itemPrice * itemQuantity;
    }
} // end Invoice
