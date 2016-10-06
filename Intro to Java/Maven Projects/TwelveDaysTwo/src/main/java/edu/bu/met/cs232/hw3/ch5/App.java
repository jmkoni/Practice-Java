package edu.bu.met.cs232.hw3.ch5;

import java.util.ArrayList;

/**
 * TwelveDaysTwo
 * 5.29
 * Created by Jennifer Konikowski on 2/14/16.
 *
 * Write an application that uses repetition and switch statements to print
 * the song “The Twelve Days of Christmas.” One switch statement should be
 * used to print the day (“first,” “second,” and so on). A separate switch
 * statement should be used to print the remainder of each verse.
 *
 * I'm not sure I really got this the way it should be. The switch statements
 * are really bulky and the code does not feel very DRY. When I reworked the code to
 * make it testable, it DRYed up a bit, but I don't really need to assign a day in the
 * second loop. Not sure if I'm just doing it wrong.
 */

public class App {
    public static void main(String[] args){
      // initialize string ArrayLists
      ArrayList<String> dayGift;
      ArrayList<String> secondDay;
        // loop through each days, starting with day 1
        for(int i = 1; i <= 12; i++){
          dayGift = assignDaysAndGifts(i);
            // print out the first day
            System.out.printf("On the %s day of Christmas, my true love sent to me %s",
                dayGift.get(0), dayGift.get(1));
            if (i == 1){
                // if day 1, end with period and new line
                System.out.printf(".%n");
            } else {
                // loop through remainder of days
                for (int j = (i - 1); j >= 1; j--){
                    if (j == 1) {
                        // if last in the line, put and
                        System.out.print(" and ");
                    } else {
                        // otherwise, add a comma
                        System.out.print(", ");
                    }
                    // assign gift for new day
                    secondDay = assignDaysAndGifts(j);
                    System.out.printf("%s", secondDay.get(1));
                }
                System.out.printf(".%n");
            }
        }
    }

    public static ArrayList<String> assignDaysAndGifts(int i){
      // assign the correct value for day and gift
      ArrayList<String> dayGift = new ArrayList<String>();

      switch (i) {
        case 1:
          dayGift.add("first");
          dayGift.add("a partridge in a pear tree");
          break;
        case 2:
          dayGift.add("second");
          dayGift.add("two turtle doves");
          break;
        case 3:
          dayGift.add("third");
          dayGift.add("three french hens");
          break;
        case 4:
          dayGift.add("fourth");
          dayGift.add("four calling birds");
          break;
        case 5:
          dayGift.add("fifth");
          dayGift.add("five golden rings");
          break;
        case 6:
          dayGift.add("sixth");
          dayGift.add("six geese a-laying");
          break;
        case 7:
          dayGift.add("seventh");
          dayGift.add("seven swans a-swimming");
          break;
        case 8:
          dayGift.add("eighth");
          dayGift.add("eight maids a-milking");
          break;
        case 9:
          dayGift.add("ninth");
          dayGift.add( "nine lords a-leaping");
          break;
        case 10:
          dayGift.add("tenth");
          dayGift.add("ten ladies dancing");
          break;
        case 11:
          dayGift.add("eleventh");
          dayGift.add("eleven pipers piping");
          break;
        case 12:
          dayGift.add("twelfth");
          dayGift.add("twelve drummers drumming");
          break;
        default:
          dayGift.add("not-really-a-day-of-Christmas");
          dayGift.add("a lump of coal");
      }
      return dayGift;
    }
}