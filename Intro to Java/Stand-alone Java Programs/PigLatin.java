package edu.bu.met.cs232;

/**
 * PigLatin.java
 * 14.7
 * Created by Jennifer Konikowski on 2/7/16.
 *
 * Translate English words into Pig Latin. Method printLatinWord should display each word.
 * Keep a running display of all translated words in a text area (not sure what this means...)
 */
import java.util.Scanner;

public class PigLatin {
    public static void main(String[] args) {
        PigLatin plTranslation = new PigLatin(); // created to call method
        Scanner input = new Scanner(System.in);
        String englishSentence, continueString; // intialize variables used in loop
        boolean continueLoop = true; // initialize boolean for loop
        while (continueLoop) {
            System.out.print("Enter sentence to be translated: "); //prompt
            englishSentence = input.nextLine(); // get sentence input
            plTranslation.printLatinWord(englishSentence); // pass sentence to translator

            System.out.print("Would you like to translate again? (y or n) "); // prompt to continue
            continueString = input.nextLine(); // get y or n
            if (continueString.equalsIgnoreCase("n")){
                continueLoop = false; // set to false if user does not want to continue
            }
        }
    } // end main

    public void printLatinWord(String origString) {
        String[] wordArray = origString.split(" "); // split string on spaces
        String transString = ""; // initialize translated string
        for (String word: wordArray) {
            String transWord = word.substring(1) + word.substring(0,1) + "ay"; // translate each word
            transString += transWord + " "; // add words back to string as translated
        }
        System.out.println(transString); // print out translated string
    } // end printLatinWord
} // end PigLatin