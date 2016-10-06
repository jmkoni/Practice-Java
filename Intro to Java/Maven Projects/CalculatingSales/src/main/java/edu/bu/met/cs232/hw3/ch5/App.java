package edu.bu.met.cs232.hw3.ch5;

/**
 * CalculatingSales
 * 5.17
 * Created by Jennifer Konikowski on 2/14/16.
 *
 * An online retailer sells five products whose retail prices are as follows:
 *    Product 1, $2.98
 *    Product 2, $4.50
 *    Product 3, $9.98
 *    Product 4, $4.49
 *    Product 5, $6.87
 * Write an application that reads a series of pairs of numbers as follows:
 *    a) product number
 *    b) quantity sold
 *
 * Your program should use a switch statement to determine the retail price
 * for each product. It should calculate and display the total retail value
 * of all products sold. Use a sentinel-controlled loop to determine when the
 * program should stop looping and display the final results.
 */
    import java.util.Scanner;

public class App {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    // initialize variables
    String num_quant_string;
    String[] num_quant_list;
    int product_quant;
    float product_price = 0.0f;
    int product_id;
    float total_value = 0.0f;
    // start loop to get list of products
    while(true){
      // prompt
      System.out.print("Please enter a product number then the quantity " +
          "sold (num," +
          "quant): ");
      num_quant_string = input.nextLine();
      num_quant_list = num_quant_string.split("\\s*(,|\\s)\\s*"); // comma or space
      product_id = Integer.parseInt(num_quant_list[0]);
      product_quant = Integer.parseInt(num_quant_list[1]);

      // set up switch statement to determine product price
      product_price = getProductPrice(product_id);
      if(product_price == 0.1f){
        break;
      }
      total_value += product_price * product_quant; // calculate total
    }
    // print out total
    System.out.printf("Total value for all products sold is $%.2f.%n", total_value);
    input.close(); // close Scanner
  }

  public static float getProductPrice(int product_id){
    switch (product_id) {
      case 0:
        return 0.1f;
      case 1:
        return 2.98f;
      case 2:
        return 4.50f;
      case 3:
        return 9.98f;
      case 4:
        return 4.49f;
      case 5:
        return 6.87f;
      default:
        return 0.1f;
    }
  }
}
