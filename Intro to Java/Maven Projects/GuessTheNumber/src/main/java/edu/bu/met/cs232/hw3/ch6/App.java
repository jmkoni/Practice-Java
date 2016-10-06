package edu.bu.met.cs232.hw3.ch6;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

/**
 * GuessTheNumber
 * 6.30
 * Created by Jennifer Konikowski on 2/20/2016
 *
 * Write an application that plays “guess the number” as follows: Your program chooses
 * the number to be guessed by selecting a random integer in the range 1 to 1000. The
 * application displays the prompt Guess a number between 1 and 1000. The player inputs
 * a first guess. If the player's guess is incorrect, your program should display Too
 * high. Try again. or Too low. Try again. to help the player “zero in” on the correct
 * answer. The program should prompt the user for the next guess. When the user enters
 * the correct answer, display Congratulations. You guessed the number!, and allow the
 * user to choose whether to play again. [Note: The guessing technique employed in this
 * problem is similar to a binary search, which is discussed in Chapter 19, Searching,
 * Sorting and Big O.]
 *
 */
public class App 
{
  public static void main( String[] args )
  {
    Scanner input = new Scanner(System.in);
    int initialNumber;
    String userPlays;
    boolean guessNotCorrect;
    int randomNumber;
    while (true) {
      guessNotCorrect = true;
      randomNumber = ThreadLocalRandom.current().nextInt(1, 1001);;
      while (guessNotCorrect) {
        System.out.print("Enter guess between 1 and 1000: ");
        initialNumber = input.nextInt();
        guessNotCorrect = guessEvaluator(randomNumber, initialNumber);
      }
      System.out.print("Keep playing? (Y/N) ");
      userPlays = input.next();
      if (userPlays.equals("N") || userPlays.equals("n")) {
        System.out.println("Thanks for playing!");
        break;
      }
      System.out.println("");
    }
    input.close();
  }
  public static boolean guessEvaluator(int actualNumber, int guessedNumber){
    if (guessedNumber > actualNumber) {
      System.out.println("Too high. Try again.");
      return true;
    } else if (guessedNumber < actualNumber) {
      System.out.println("Too low. Try again.");
      return true;
    } else {
      System.out.println("Congratulations. You guessed the number!");
      return false;
    }
  }
}
