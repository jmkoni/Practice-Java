package edu.bu.met.cs232.hw4.ch8;

import java.util.Scanner;

/**
 * This application uses TicTacToe to play a tic-tac-toe game. The only thing that
 * really happens here is that it asks for a number of players.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of players (1 or 2): ");
        int numPlayers = input.nextInt();
        game.playGame(numPlayers);
    }
}
