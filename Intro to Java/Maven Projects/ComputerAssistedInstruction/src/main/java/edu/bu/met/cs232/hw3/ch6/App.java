package edu.bu.met.cs232.hw3.ch6;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * ComputerAssistedInstruction
 * Ch6 Making a Difference
 * Created by Jennifer Konikowski on 2/20/2016
 *
 * The use of computers in education is referred to as computer-assisted instruction
 * (CAI). Write a program that will help an elementary school student learn
 * multiplication. Use a SecureRandom object to produce two positive one-digit integers
 * (function getRandom).
 * The program should then prompt the user with a question, such as
 *    How much is 6 times 7?
 * The student then inputs the answer. Next, the program checks the student’s answer.
 * If it’s correct, display the message "Very good!" and ask another multiplication
 * question. If the answer is wrong, display the message "No. Please try again." and
 * let the student try the same question repeatedly until the student finally gets it
 * right. A separate method should be used to generate each new question. This method
 * should be called once when the application begins execution and each time the user
 * answers the question correctly.
 *
 * One problem in CAI environments is student fatigue. This can be reduced by varying
 * the computer’s responses to hold the student’s attention. Modify the program so that
 * various comments are displayed for each answer as follows:
 *
 *   Possible responses to a correct answer:
 *     Very good!
 *     Excellent!
 *     Nice work!
 *     Keep up the good work!
 *
 *   Possible responses to an incorrect answer:
 *     No. Please try again.
 *     Wrong. Try once more.
 *     Don't give up!
 *     No. Keep trying.
 *
 * Use random-number generation to choose a number from 1 to 4 that will be used to
 * select one of the four appropriate responses to each correct or incorrect answer.
 * Use a switch statement to issue the responses.
 *
 * More sophisticated computer-assisted instruction systems monitor the student’s
 * performance over a period of time. The decision to begin a new topic is often based
 * on the student’s success with previous topics. Modify to count the number of correct
 * and incorrect responses typed by the student. After the student types 10 answers,
 * your program should calculate the percentage that are correct. If the percentage is
 * lower than 75%, display "Please ask your teacher for extra help.", then reset the
 * program so another student can try it. If the percentage is 75% or higher, display
 * "Congratulations, you are ready to go to the next level!", then reset the program so
 * another student can try it.
 *
 * Modify the program to allow the user to enter a difficulty level. At a difficulty
 * level of 1, the program should use only single-digit numbers in the problems; at a
 * difficulty level of 2, numbers as large as two digits, and so on.
 *
 * Modify the program to allow the user to pick a type of arithmetic problem to study.
 * An option of 1 means addition problems only, 2 means subtraction problems only, 3
 * means multiplication problems only, 4 means division problems only and 5 means a
 * random mixture of all these types.
 */
public class App {
  private static Scanner input = new Scanner(System.in);
  private static SecureRandom random = new SecureRandom();
  public static void main(String[] args) {
    while(true) {
      System.out.printf("Welcome to super fun math practice!%nTo exit this program, " +
          "enter 0 in either of the following prompts.%nWe have multiple difficulty" +
          " levels:%n1 - single digits%n2 - as large as 2 digits%netc...%n");
      System.out.printf("Please entered desired difficulty level: ");
      int difficultyLevel = input.nextInt();
      if (difficultyLevel == 0) {
        break;
      }
      System.out.printf(
          "You can choose from the following problem types:%n  1 - addition" +
              " problems only%n  2 - subtraction problems only%n  3 - multiplication problems" +
              " only%n  4 - division problems only%n  5 - random mixture%n");
      System.out.printf("Please enter desired problem type: ");
      int problemType = input.nextInt();
      System.out.println("");
      if (problemType == 0) {
        break;
      }
      float percentageCorrect = tenProblems(difficultyLevel, problemType);
      if (percentageCorrect >= 0.75) {
        System.out.println("Congratulations, you are ready to go to the next level!");
      } else {
        System.out.println();
        System.out.println("Please ask your teacher for extra help.");
      }
      System.out.println("");
    }
  }

  public static float tenProblems(int difficultyLevel, int problemType) {
    int first, second, problemTypeInstance;
    boolean result;
    int totalCorrect = 0;
    for (int i = 0; i < 10; i++){
      first = getRandom(difficultyLevel);
      second = getRandom(difficultyLevel);
      if (problemType == 5){
        problemTypeInstance = random.nextInt(3) + 1;
      } else {
        problemTypeInstance = problemType;
      }
      result = printGetAndCompare(first, second, problemTypeInstance);
      if (result) {
        totalCorrect += 1;
      }
      while(result == false) {
        result = printGetAndCompare(first, second, problemTypeInstance);
      }
    }
    return totalCorrect / 10.0f;
  }

  public static int getRandom(int difficulty) {
    String limitString = "";
    for (int i = 0; i < difficulty; i++) {
      limitString += "9";
    }
    return random.nextInt(Integer.parseInt(limitString)) + 1;
  }

  public static boolean printGetAndCompare(int first, int second, int
      problemTypeInstance){
    int correctAnswer, userAnswer;
    boolean result;
    correctAnswer = printProblem(first, second, problemTypeInstance);
    userAnswer = input.nextInt();
    result = compareAnswer(userAnswer, correctAnswer);
    System.out.println(generateComment(result));
    System.out.println("");
    return result;
  }

  public static int printProblem(int first, int second, int problemType) {
    int correctAnswer;
    if (problemType == 1) {
      System.out.printf("%d + %d = ? ", first, second);
      correctAnswer = addition(first, second);
    } else if (problemType == 2) {
      System.out.printf("%d - %d = ? ", first, second);
      correctAnswer =  subtraction(first, second);
    } else if (problemType == 3) {
      System.out.printf("%d * %d = ? ", first, second);
      correctAnswer =  multiplication(first, second);
    } else {
      System.out.printf("%d / %d = ? ", first, second);
      correctAnswer =  division(first, second);
    }
    return correctAnswer;
  }

  public static String generateComment(boolean answerCorrect){
    int numAnswer = random.nextInt(3);
    String[] correctResponses = {"Very good!","Excellent!","Nice work!", "Keep up the " +
        "good work!"};
    String[] wrongResponses = { "No. Please try again.", "Wrong. Try once more.",
        "Don't give up!", "No. Keep trying."};
    if (answerCorrect){
      return correctResponses[numAnswer];
    } else {
      return wrongResponses[numAnswer];
    }
  }

  public static int multiplication(int first, int second) {
    return first * second;
  }

  public static int subtraction(int first, int second) {
    return first - second;
  }

  public static int addition(int first, int second) {
    return first + second;
  }

  public static int division(int first, int second) {
    return first / second;
  }

  public static boolean compareAnswer(int userAnswer, int correctAnswer) {
    if (correctAnswer == userAnswer) {
      return true;
    } else {
      return false;
    }
  }
}
