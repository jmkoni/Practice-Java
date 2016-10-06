package edu.bu.met.cs232.hw4.ch8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * TicTacToeTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the TicTacToe application.
 */
public class TicTacToeTest {
  private TicTacToe ticTac;
//  private enum Status { X, O, EMPTY }
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    ticTac = new TicTacToe();
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void tearDown() throws Exception {
    ticTac = null;
    System.setOut(null);
  }

  @Test
  public void testPrintBoard() throws Exception {
    String expectedOutput = String.format("-------%n| | | |%n-------%n| | | " +
        "|%n-------%n| | | |%n-------%n");
    ticTac.printBoard();
    assertEquals(expectedOutput, outContent.toString());
  }

  // tested private functions. commented out since functions are... private
//  @Test
//  public void testComputerTurn() throws Exception {
//    ticTac.computerTurn();
//    ticTac.printBoard();
//    assertThat(outContent.toString(), CoreMatchers.containsString("O"));
//  }
//
//  @Test
//  public void testParseCoords() throws Exception {
//    int[] coords = {1,2};
//    assertArrayEquals(coords,ticTac.parseCoords("1,2"));
//  }
//
//  @Test
//  public void testIsPlayerOneWinner() throws Exception {
//    makePlayerOneWinRow();
//    assertTrue(ticTac.isPlayerOneWinner());
//    assertEquals("Player 1 is the winner!\n", outContent.toString());
//  }
//
//  @Test
//  public void testIsPlayerTwoWinner() throws Exception {
//    makePlayerTwoWinRow();
//    assertTrue(ticTac.isPlayerTwoWinner());
//    assertEquals("Player 2 is the winner!\n", outContent.toString());
//  }
//
//  @Test
//  public void testCheckWinnerTrue() throws Exception {
//    makePlayerOneWinRow();
//    assertTrue(ticTac.checkWinner(ticTac.getPlayerOneSymbol()));
//  }
//
//  @Test
//  public void testCheckWinnerFalse() throws Exception {
//    assertFalse(ticTac.checkWinner(ticTac.getPlayerOneSymbol()));
//  }
//
//  @Test
//  public void testIsDrawTrue() throws Exception {
//    createDraw();
//    assertTrue(ticTac.isDraw());
//  }
//
//  @Test
//  public void testIsDrawFalse() throws Exception {
//    makePlayerOneWinRow();
//    assertFalse(ticTac.isDraw());
//  }
//
//  @Test
//  public void testCheckDiagonalTrue() throws Exception {
//    makePlayerOneWinDiagonal();
//    assertTrue(ticTac.checkDiagonal(ticTac.getPlayerOneSymbol()));
//  }
//
//  @Test
//  public void testCheckDiagonalFalse() throws Exception {
//    makePlayerOneWinRow();
//    assertFalse(ticTac.checkDiagonal(ticTac.getPlayerOneSymbol()));
//  }
//
//  @Test
//  public void testLoopRowsColumnsRow() throws Exception {
//    makePlayerOneWinRow();
//    assertTrue(ticTac.loopRowsColumns(ticTac.getPlayerOneSymbol(), true));
//  }
//
//  @Test
//  public void testLoopsRowsColumnsColumn() throws Exception {
//    makePlayerOneWinRow();
//    assertFalse(ticTac.loopRowsColumns(ticTac.getPlayerOneSymbol(), false));
//  }
//
//  @Test
//  public void testPlayerFullTurn() throws Exception {
//    String expectedOutput = String.format("-------%n|X| | |%n-------%n| | | " +
//        "|%n-------%n| | | |%n-------%n");
//    ticTac.playerFullTurn(ticTac.getPlayerOneSymbol(), "0,0");
//    assertEquals(expectedOutput, outContent.toString());
//  }
//
//  @Test
//  public void testPlayerTurnTrue() throws Exception {
//    assertTrue(ticTac.playerTurn(0,0, ticTac.getPlayerOneSymbol()));
//  }
//
//  @Test
//  public void testPlayerTurnFalse() throws Exception {
//    String expectedOutput = "This space is already taken! Please enter another spot.\n";
//    ticTac.playerTurn(0,0, ticTac.getPlayerOneSymbol());
//    assertFalse(ticTac.playerTurn(0,0, ticTac.getPlayerOneSymbol()));
//    assertEquals(expectedOutput, outContent.toString());
//  }
//
//  @Test
//  public void testPrintStatusX() throws Exception {
//    assertEquals("X", TicTacToe.printStatus(ticTac.getPlayerOneSymbol()));
//  }
//
//  @Test
//  public void testPrintStatusO() throws Exception {
//    assertEquals("O", TicTacToe.printStatus(ticTac.getPlayerTwoSymbol()));
//  }
//
//  private void createDraw() {
//    ticTac.playerTurn(0, 0, ticTac.getPlayerOneSymbol());
//    ticTac.playerTurn(0, 1, ticTac.getPlayerOneSymbol());
//    ticTac.playerTurn(1, 2, ticTac.getPlayerOneSymbol());
//    ticTac.playerTurn(2, 0, ticTac.getPlayerOneSymbol());
//    ticTac.playerTurn(2, 2, ticTac.getPlayerOneSymbol());
//    ticTac.playerTurn(1, 1, ticTac.getPlayerTwoSymbol());
//    ticTac.playerTurn(1, 0, ticTac.getPlayerTwoSymbol());
//    ticTac.playerTurn(0, 2, ticTac.getPlayerTwoSymbol());
//    ticTac.playerTurn(2, 1, ticTac.getPlayerTwoSymbol());
//  }
//
//  private void makePlayerOneWinRow() {
//    ticTac.playerTurn(0, 0, ticTac.getPlayerOneSymbol());
//    ticTac.playerTurn(0, 1, ticTac.getPlayerOneSymbol());
//    ticTac.playerTurn(0, 2, ticTac.getPlayerOneSymbol());
//  }
//
//  private void makePlayerOneWinDiagonal() {
//    ticTac.playerTurn(0, 0, ticTac.getPlayerOneSymbol());
//    ticTac.playerTurn(1, 1, ticTac.getPlayerOneSymbol());
//    ticTac.playerTurn(2, 2, ticTac.getPlayerOneSymbol());
//  }
//
//  private void makePlayerTwoWinRow() {
//    ticTac.playerTurn(0, 0, ticTac.getPlayerTwoSymbol());
//    ticTac.playerTurn(0, 1, ticTac.getPlayerTwoSymbol());
//    ticTac.playerTurn(0, 2, ticTac.getPlayerTwoSymbol());
//  }
}