package edu.bu.met.cs232.hw4.ch8;

import java.util.Scanner;

/**
 * TicTacToe
 * 8.17
 * Created by Jennifer Konikowski on 2/25/16.
 *
 * Create a class TicTacToe that will enable you to write a program to play Tic-Tac-Toe
 * . The class contains a private 3-by-3 two-dimensional array. Use an enum type to
 * represent the value in each cell of the array. The enum’s constants should be named
 * X, O and EMPTY (for a position that does not contain an X or an O). The constructor
 * should initialize the board elements to EMPTY. Allow two human players. Wherever the
 * first player moves, place an X in the specified square, and place an O wherever the
 * second player moves. Each move must be to an empty square. After each move,
 * determine whether the game has been won and whether it’s a draw. If you feel
 * ambitious, modify your program so that the computer makes the moves for one of the
 * players. Also, allow the player to specify whether he or she wants to go first or
 * second.
 *
 * This class has two public methods:
 *   * playGame(int numPlayers)
 *     - This function runs through the entire gameplay. First it loops through Player
 *     Ones turn, then Player Twos. The loop is required in case the player picks a
 *     space that has already been chosen.
 *   * printBoard()
 *     - This function simply prints the board in a nice human readable format.
 *
 */
public class TicTacToe {
  private enum Status { X, O, EMPTY };
  private Status[][] board;
  private Scanner input;

  public TicTacToe() {
    this.board = new Status[][] {{Status.EMPTY, Status.EMPTY, Status.EMPTY}, {Status
        .EMPTY, Status.EMPTY, Status.EMPTY}, {Status.EMPTY, Status.EMPTY, Status.EMPTY}};
  }

  public void playGame(int numPlayers){
    input = new Scanner(System.in);
    System.out.println("Let's play!");
    System.out.println("When inputting a space, keep in mind the x, y coordinates.");
    System.out.println("You'll want to enter a space as 0,0, for the top left corner " +
        "(as an example).");
    boolean multiplePlayers;
    String coords;
    if (numPlayers == 1){
      multiplePlayers = false;
    } else {
      multiplePlayers = true;
    }
    while (true) {
      boolean playerOneTurn = true;
      while (playerOneTurn) {
        if (multiplePlayers) {
          System.out.print("Player 1, please select your space: ");
        } else {
          System.out.print("Please select your space: ");
        }
        coords = input.nextLine();
        playerOneTurn = playerFullTurn(Status.X, coords);
      }
      if(isPlayerOneWinner() || isDraw()) {
        input.close();
        return;
      }

      boolean playerTwoTurn = true;
      if (multiplePlayers) {
        while (playerTwoTurn) {
          System.out.print("Player 2, please select your space: ");
          coords = input.nextLine();
          playerTwoTurn = playerFullTurn(Status.O, coords);
        }
      } else {
        System.out.println("Computer's (Player 2) turn");
        computerTurn();
        printBoard();
      }
      if(isPlayerTwoWinner() || isDraw()) {
        input.close();
        return;
      }
    }
  }

  public void printBoard(){
    System.out.printf("-------%n");
    System.out.printf("|%s|%s|%s|%n", printStatus(this.board[0][0]), printStatus(this
        .board[0][1]), printStatus(this.board[0][2]));
    System.out.printf("-------%n");
    System.out.printf("|%s|%s|%s|%n", printStatus(this.board[1][0]), printStatus(this
        .board[1][1]), printStatus(this.board[1][2]));
    System.out.printf("-------%n");
    System.out.printf("|%s|%s|%s|%n", printStatus(this.board[2][0]), printStatus(this
        .board[2][1]), printStatus(this.board[2][2]));
    System.out.printf("-------%n");
  }
  // just for tests
//  public Status getPlayerOneSymbol() {
//    return Status.X;
//  }
//  // just for tests
//  public Status getPlayerTwoSymbol() {
//    return Status.O;
//  }

  private void computerTurn(){
    boolean spaceAvailable = false;
    while(spaceAvailable == false){
      int x = (int) Math.floor(Math.random() * 3);
      int y = (int) Math.floor(Math.random() * 3);
      Status currentStat = this.board[x][y];
      if (currentStat == Status.EMPTY){
        this.board[x][y] = Status.O;
        return;
      }
    }
  }

  private int[] parseCoords(String coords){
    String[] splitCoords = coords.split(",");
    int x = Integer.parseInt(splitCoords[0]);
    int y = Integer.parseInt(splitCoords[1]);
    if (x > 2){
      x = 2;
    }
    if (y > 2){
      y = 2;
    }
    int[] returnCoords = {x,y};
    return returnCoords;
  }

  private boolean isPlayerOneWinner(){
    if (checkWinner(Status.X)){
      System.out.println("Player 1 is the winner!");
      return true;
    } else {
      return false;
    }
  }

  private boolean isPlayerTwoWinner(){
    if (checkWinner(Status.O)){
      System.out.println("Player 2 is the winner!");
      return true;
    } else {
      return false;
    }
  }

  private boolean checkWinner(Status player){
    if (loopRowsColumns(player, true)) {
      return true;
    } else if (loopRowsColumns(player, false)) {
      return true;
    } else if (checkDiagonal(player)) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isDraw() {
    boolean isADraw = true;
    for (int i = 0; i < 3; i++ ) {
      for (int j = 0; j < 3; j++) {
        if (this.board[i][j] == Status.EMPTY){
          isADraw = false;
        }
      }
    }
    if(isADraw){
      System.out.println("Draw!");
    }
    return isADraw;
  }

  private boolean checkDiagonal(Status player){
    if (this.board[0][0] == player && this.board[1][1] == player && this.board[2][2] ==
        player){
      return true;
    } else if (this.board[0][2] == player && this.board[1][1] == player && this
        .board[2][0] == player){
      return true;
    } else {
      return false;
    }
  }

  private boolean loopRowsColumns(Status player, boolean isRow) {
    Status currentStat;
    for (int i = 0; i < 3; i++ ){
      int fullHouse = 0;
      for (int j = 0; j < 3; j++){
        if (isRow) {
          currentStat = this.board[i][j];
        } else {
          currentStat = this.board[j][i];
        }
        if (currentStat == player){
          ++fullHouse;
        }
      }
      if (fullHouse == 3){
        return true;
      }
    }
    return false;
  }

  private boolean playerFullTurn(Status playerSymbol, String coords){
    int[] xY = parseCoords(coords);
    if (playerTurn(xY[0], xY[1], playerSymbol)) {
      printBoard();
      return false;
    } else {
      return true;
    }
  }

  private boolean playerTurn(int x, int y, Status playerSymbol) {
    if(this.board[x][y] == Status.EMPTY){
      this.board[x][y] = playerSymbol;
      return true;
    } else {
      System.out.println("This space is already taken! Please enter another spot.");
      return false;
    }
  }

  private static String printStatus(Status currentStatus){
    if (currentStatus == Status.X){
      return "X";
    } else if (currentStatus == Status.O){
      return "O";
    } else {
      return " ";
    }
  }

}
