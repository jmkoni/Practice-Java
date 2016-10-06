package edu.bu.met.cs232.hw3.ch5;

/**
 * TwelveDays
 * 5.29
 * Created by Jennifer Konikowski on 2/14/16.
 *
 * Write an application that uses repetition and switch statements to print
 * the song “The Twelve Days of Christmas.” One switch statement should be
 * used to print the day (“first,” “second,” and so on). A separate switch
 * statement should be used to print the remainder of each verse.
 *
 * I missed the instruction to use two switch statements before I wrote this.
 * I felt like this ended up being cleaner, so I kept it. I rewrote it using
 * two switch statements in TwelveDaysTwo.
 */

import java.util.HashMap;
public class App {
  public static void main(String[] args){
    // initialize hashmap for lyrics
    HashMap<Integer, String[]> gifts_for_days = new HashMap<Integer, String[]>();
    // create string arrays
    String[] first = {"first", "a partridge in a pear tree"};
    String[] second = {"second", "two turtle doves"};
    String[] third = {"third", "three french hens"};
    String[] fourth = {"fourth", "four calling birds"};
    String[] fifth = {"fifth", "five golden rings"};
    String[] sixth = {"sixth", "six geese a-laying"};
    String[] seventh = {"seventh", "seven swans a-swimming"};
    String[] eighth = {"eighth", "eight maids a-milking"};
    String[] ninth = {"ninth", "nine lords a-leaping"};
    String[] tenth = {"tenth", "ten ladies dancing"};
    String[] eleventh = {"eleventh", "eleven pipers piping"};
    String[] twelfth = {"twelfth", "twelve drummers drumming"};

    // add keys + arrays to map
    gifts_for_days.put(1, first);
    gifts_for_days.put(2, second);
    gifts_for_days.put(3, third);
    gifts_for_days.put(4, fourth);
    gifts_for_days.put(5, fifth);
    gifts_for_days.put(6, sixth);
    gifts_for_days.put(7, seventh);
    gifts_for_days.put(8, eighth);
    gifts_for_days.put(9, ninth);
    gifts_for_days.put(10, tenth);
    gifts_for_days.put(11, eleventh);
    gifts_for_days.put(12, twelfth);

    // loop through all the days
    printOutDays(gifts_for_days);
  }

  // move loop to function so it can be tested.
  public static void printOutDays(HashMap<Integer, String[]> gifts_for_days) {
    for(int i = 1; i <= gifts_for_days.size(); i++){
      // print out gift for current day
      System.out.printf("On the %s day of Christmas, my true love sent to me %s",
          gifts_for_days.get(i)[0], gifts_for_days.get(i)[1]);
      if (i == 1){
        // if it's the first day, put a period and then a new line
        System.out.printf(".%n");
      } else {
        // loop through previous days gifts
        for (int j = (i - 1); j >= 1; j--){
          if (j == 1) {
            // if the last item, put and
            System.out.print(" and ");
          } else {
            // otherwise, just a comma
            System.out.print(", ");
          }
          // print out gift
          System.out.printf("%s", gifts_for_days.get(j)[1]);
        }
        System.out.printf(".%n");
      }
    }
  }
}