package edu.bu.met.cs232;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * WordsReversed.java
 * 14.9
 * Created by Jennifer Konikowski on 2/7/16.
 *
 * This application inputs a line of text, tokenizes the line with split and outputs the tokens in reverse order.
 */
public class WordsReversed {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter sentence to be reversed: "); //prompt
        String origSentence = input.nextLine(); // get sentence input
        String[] origArray = origSentence.split(" "); // split sentence
        List<String> origList = Arrays.asList(origArray); // convert Array to List so it can be changed
        Collections.reverse(origList); // use Collections.reverse to reverse array
        String reverseString = ""; // initialize ending string
        for (String word: origList) {
            reverseString += word + " "; // add words back to string in reverse
        }

        System.out.println(reverseString); // print out the reversed string
    } // end main
}
