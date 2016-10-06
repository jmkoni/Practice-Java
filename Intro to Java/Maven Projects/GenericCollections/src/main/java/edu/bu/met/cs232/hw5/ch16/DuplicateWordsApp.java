package edu.bu.met.cs232.hw5.ch16;

import java.util.Scanner;

/**
 * Created by jmkoni on 3/31/16.
 */
public class DuplicateWordsApp {
  public static void main( String[] args )
  {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a sentence: ");
    String sentence = input.nextLine();
    DuplicateWords dups = new DuplicateWords(sentence);

    System.out.println("Here is a hash of the words:");
    System.out.println(dups.prettyPrintWordNums());
    System.out.println("");
    System.out.println(dups.prettyPrintDups());
    input.close();
  }
}
