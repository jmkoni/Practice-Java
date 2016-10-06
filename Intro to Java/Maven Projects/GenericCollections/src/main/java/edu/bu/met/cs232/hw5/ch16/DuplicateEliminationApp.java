package edu.bu.met.cs232.hw5.ch16;

import java.util.Scanner;

/**
 * This application uses DuplicateElimination. Allow the user to search for a first name.
 *
 */
public class DuplicateEliminationApp
{
  public static void main( String[] args )
  {
    DuplicateElimination listOfNames;
    Scanner input = new Scanner(System.in);
    System.out.print("Would you like to enter a series of first names (otherwise " +
        "uses default)? (y/n): ");
    String enterSeries = input.nextLine();
    if (enterSeries.equalsIgnoreCase("y")) {
      System.out.print("Please enter a list of comma separated names: ");
      String names = input.nextLine();
      listOfNames = new DuplicateElimination(names);
    } else {
      listOfNames = new DuplicateElimination();
    }
    // just to see if the list is printing out correctly
    System.out.println(listOfNames.getUniqueFirstNames());

    System.out.print("Would you like to search the list for a name? (y/n): ");
    String searchNames = input.nextLine();
    if (searchNames.equalsIgnoreCase("y")) {
      System.out.print("Please enter a name: ");
      String nameSearch = input.nextLine();
      listOfNames.showSearchResults(nameSearch);
    } else {
      System.out.println("Ok, bye!");
    }
    input.close();
  }
}
