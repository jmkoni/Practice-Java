package edu.bu.met.cs232;

import java.util.Scanner;

/**
* CompareStringPortions.java
* 14.4
* Created by Jennifer Konikowski on 2/7/16.
*
* This application uses regionMatches to compare two strings inputed by the user.
 * It should input the number of characters to be compared and the starting index.
 * It should state whether the strings are equal. Case should be ignored.
*/
import java.util.Scanner;
public class CompareStringPortions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string1: ");
        String string1 = input.nextLine();
        System.out.print("Enter string2: ");
        String string2 = input.nextLine();
        System.out.print("Number of characters to be compared: ");
        int numChars = input.nextInt();
        System.out.print("Starting index: ");
        int startIndex = input.nextInt();

        boolean matches = string1.regionMatches(true, startIndex, string2, startIndex, numChars);
        System.out.printf("Are the two substrings equal? %b%n", matches);
    }
}
