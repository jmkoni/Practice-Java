package edu.bu.met.cs232.hw5.ch16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * DuplicateElimination
 * 16.13
 * Created by Jennifer Konikowski on 3/23/16.
 *
 * Write a program that reads a series of first names and eliminates duplicates by
 * storing them in a Set. Allow the user to search for a first name.
 *
 * I have set up a default string that can be used for testing, or if the user chooses
 * to go with the default list.
 *
 */
public class DuplicateElimination {
  private Set<String> uniqueFirstNames;
  private Scanner input;

  public DuplicateElimination() {
    this("Jennifer,April,Oliver,Kevin,Kara, Kara");
  }
  public DuplicateElimination(String names) {
    String[] nameList = splitStringToArray(names);
    this.uniqueFirstNames = new HashSet<String>(Arrays.asList(nameList));
  }

  public String[] splitStringToArray(String names) {
    return names.replaceAll("\\s+","").split(",");
  }

  public Set<String> getUniqueFirstNames() {
    return this.uniqueFirstNames;
  }

  public boolean searchFirstNames(String search) {
    return this.uniqueFirstNames.contains(search);
  }

  public void showSearchResults(String search) {
    boolean nameInList = searchFirstNames(search);
    if (nameInList) {
      System.out.printf("Yay, %s is in the list of names.", search);
    } else {
      System.out.printf("Sorry, %s is not in the list of names.", search);
    }
  }

}
