package edu.bu.met.cs232;

/**
 * CompareStrings.java
 * 14.3
 * Created by Jennifer Konikowski on 2/7/16.
 *
 * This application uses compareTo to compare two strings inputed vy the user.
 * The output is whether the first string is less than, equal to, or greater than the second
 */
import java.util.Scanner;
public class CompareStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string1: ");
        String string1 = input.nextLine();
        System.out.print("Enter string2: ");
        String string2 = input.nextLine();

        // compare the two strings
        int result = string1.compareTo(string2);
        if (result == 0) {
            System.out.println("String1 is equal to String2.");
        } else if ( result < 0){
            System.out.println("String1 is less than String2.");
        } else {
            System.out.println("String1 is greater than String2.");
        }

    }
}
