package edu.bu.met.cs232.hw3.ch6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the DisplayingSquareOfAsterisks application.
 * Since this application only prints to screen, I had to use
 * ByteArrayOutputStream and PrintStream to test that it was printing
 * the correct number of * to the screen.
 */

public class AppTest {
  private App dsa;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    System.setOut(new PrintStream(outContent));
    dsa = new App();
  }

  @After
  public void tearDown() throws Exception {
    dsa = null;
    System.setOut(null);
  }

  @Test
  public void testSquareOfAsterisks() throws Exception {
    String expected_output = String.format("****%n****%n****%n****%n");
    dsa.squareOfAsterisks(4);
    assertEquals(expected_output, outContent.toString());
  }

  @Test
  public void testSquareOfAstericksNegative() throws Exception {
    String not_expected = String.format("**%n**%n");
    dsa.squareOfAsterisks(3);
    assertNotEquals(not_expected, outContent.toString());
  }
}