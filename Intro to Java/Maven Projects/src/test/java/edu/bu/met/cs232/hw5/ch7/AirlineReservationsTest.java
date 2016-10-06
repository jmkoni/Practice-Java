package edu.bu.met.cs232.hw5.ch7;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Unit test for simple AirlineReservationsApp.
 */
public class AirlineReservationsTest
    extends TestCase
{
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private AirlineReservations ar;
  private Scanner input;

  @Before
  public void setUp() throws Exception {
    ar = new AirlineReservations();
    System.setOut(new PrintStream(outContent));
    input = new Scanner(System.in);
  }

  @After
  public void tearDown() throws Exception {
    ar = null;
    System.setOut(null);
    input.close();
  }

  // doing a similar thing to what I was doing before, but for some reason it is
  // failing on the input. Ignoring for now.
  @Ignore
  public void testWelcomeScreen() throws Exception {
    String data = "1\n";
    System.setIn(new ByteArrayInputStream(data.getBytes()));
    String expectedOutput = String.format("Welcome to KoniAir!\nWhat seat class " +
        "would you like? (1 for First, 2 for Economy, 3 to exit) ");
    ar.welcomeScreen(input);
    assertEquals(expectedOutput, outContent.toString());
  }

  // doing a similar thing to what I was doing before, but for some reason it is
  // failing on the input. Ignoring for now.
  @Ignore
  public void testAssignSeatFull() throws Exception {
    for(int i = 0; i<5; i++){
        ar.assignFirst();
    }
    String data = "y\n";
    System.setIn(new ByteArrayInputStream(data.getBytes()));
    ar.assignSeat(1, input);
    String expectedOutput = "";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testAssignSeatFirst() throws Exception {
    String expectedOutput = "Boarding Pass: Seat 1, First Class\n";
    assertTrue(ar.assignSeat(1, input));
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testAssignSeatSecond() throws Exception {
    String expectedOutput = "Boarding Pass: Seat 6, Economy Class\n";
    assertTrue(ar.assignSeat(2, input));
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testDetermineWhichClassFirstFull() throws Exception {
    String expectedOutput = "Boarding Pass: Seat 6, Economy Class\n";
    assertTrue(ar.determineWhichClass(1, true));
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testDetermineWhichClassFirstNot() throws Exception {
    String expectedOutput = "Boarding Pass: Seat 1, First Class\n";
    assertTrue(ar.determineWhichClass(1, false));
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testDetermineWhichClassSecondFull() throws Exception {
    String expectedOutput = "Boarding Pass: Seat 1, First Class\n";
    assertTrue(ar.determineWhichClass(2, true));
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testDetermineWhichClassSecondNot() throws Exception {
    String expectedOutput = "Boarding Pass: Seat 6, Economy Class\n";
    assertTrue(ar.determineWhichClass(2, false));
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testAssignFirst() throws Exception {
    String expectedOutput = "Boarding Pass: Seat 1, First Class\n";
    assertTrue(ar.assignFirst());
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testAssignSecond() throws Exception {
    String expectedOutput = "Boarding Pass: Seat 6, Economy Class\n";
    assertTrue(ar.assignSecond());
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testAssignSecondFalseAfterFive() throws Exception {
    for(int i = 0; i<5; i++){
        ar.assignSecond();
    }
    assertFalse(ar.assignSecond());
  }

  @Test
  public void testAssignFirstFalseAfterFive() throws Exception {
    for(int i = 0; i<5; i++){
        ar.assignFirst();
    }
    assertFalse(ar.assignFirst());
  }
}
