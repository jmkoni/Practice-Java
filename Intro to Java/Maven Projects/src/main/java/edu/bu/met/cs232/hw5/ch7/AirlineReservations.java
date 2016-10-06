package edu.bu.met.cs232.hw5.ch7;

import java.util.Scanner;

/**
 * AirlineReservations
 * 7.19
 * Created by jmkoni on 4/2/16.
 *
 * A small airline has just purchased a computer for its new automated reservations
 * system. You’ve been asked to develop the new system. You’re to write an application
 * to assign seats on each flight of the airline’s only plane (capacity: 10 seats).
 *
 * Your application should display the following alternatives: Please type 1 for First
 * Class and Please type 2 for Economy. If the user types 1, your application should
 * assign a seat in the firstclass section (seats 1–5). If the user types 2, your
 * application should assign a seat in the economy section (seats 6–10). Your
 * application should then display a boarding pass indicating the person’s seat number
 * and whether it’s in the first-class or economy section of the plane.
 *
 * Use a one-dimensional array of primitive type boolean to represent the seating chart
 * of the plane. Initialize all the elements of the array to false to indicate that all
 * the seats are empty. As each seat is assigned, set the corresponding element of the
 * array to true to indicate that the seat is no longer available.
 *
 * Your application should never assign a seat that has already been assigned. When the
 * economy section is full, your application should ask the person if it’s acceptable
 * to be placed in the first-class section (and vice versa). If yes, make the
 * appropriate seat assignment. If no, display the message "Next flight leaves in 3
 * hours."
 *
 * Ran into some oddities with input (looping within the app, but not closing too
 * early), so I added it as a parameter to the necessary functions. The functions that
 * require input weren't testing correctly, but they are working as I expect.
 */
public class AirlineReservations {
  private boolean[] seats;

  public AirlineReservations(){
    this.seats = new boolean[] {false, false, false, false, false, false, false, false,
        false, false};
  }

  public boolean welcomeScreen(Scanner input){
    boolean seatAssigned;
    System.out.println("Welcome to KoniAir!");
    System.out.print("What seat class would you like? (1 for First, 2 for Economy, " +
        "3 to exit) ");
    int seatClass = Integer.parseInt(input.nextLine());
    if(seatClass == 3){
      System.out.println("System exiting...");
      return false;
    }
    seatAssigned = assignSeat(seatClass, input);
    if(seatAssigned){
      System.out.println("Enjoy your flight!");
    } else {
      System.out.println("The next flight is in three hours.");
    }
    System.out.println("");
    return true;
  }

  public boolean assignSeat(int seatClass, Scanner input) {
    boolean seatAssigned;
    seatAssigned = determineWhichClass(seatClass, false);
    if(!seatAssigned){
      String stringSeatClass = (seatClass == 1) ? "economy" : "first";
      System.out.print("Is it acceptable to be placed in " + stringSeatClass + " class?" +
          " (y/n) ");
      String newClass = input.nextLine();
      if(newClass.equalsIgnoreCase("y")) {
        seatAssigned = determineWhichClass(seatClass, true);
        if(!seatAssigned){
          System.out.println("No seats available in " + stringSeatClass + " class.");
        }
      }
    }
    return seatAssigned;
  }

  public boolean determineWhichClass(int seatClass, boolean originalChoiceFull){
    boolean seatAssigned;
    if(originalChoiceFull){
      if (seatClass == 1) {
        seatAssigned = assignSecond();
      } else {
        seatAssigned = assignFirst();
      }
    } else {
      if(seatClass == 1){
        seatAssigned = assignFirst();
      } else {
        seatAssigned = assignSecond();
      }
    }
    return seatAssigned;
  }

  public boolean assignFirst(){
    for(int i = 0; i < 5; i++){
      if(!this.seats[i]){
        this.seats[i] = true;
        System.out.printf("Boarding Pass: Seat %d, First Class%n", i + 1);
        return true;
      }
    }
    return false;
  }

  public boolean assignSecond(){
    for(int i = 5; i < 10; i++){
      if(!this.seats[i]){
        this.seats[i] = true;
        System.out.printf("Boarding Pass: Seat %d, Economy Class%n", i + 1);
        return true;
      }
    }
    return false;
  }
}
