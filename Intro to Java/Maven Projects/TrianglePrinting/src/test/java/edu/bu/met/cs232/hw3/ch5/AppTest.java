package edu.bu.met.cs232.hw3.ch5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the TrianglePrinting application.
 * Since this application only prints to screen, I had to use
 * ByteArrayOutputStream and PrintStream to test that it was printing
 * the correct number of * to the screen.
 */

public class AppTest {
  private App tp = new App();
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(null);
  }

  @Test
  public void testGoingUpTriangleRight() throws Exception {
    String expected_output = String.format("***%n **%n  *%n");
    tp.goingUpTriangle(3, "right");
    assertEquals(expected_output, outContent.toString());
  }

  @Test
  public void testGoingUpTriangleLeft() throws Exception {
    String expected_output = String.format("*%n**%n***%n");
    tp.goingUpTriangle(3, "left");
    assertEquals(expected_output, outContent.toString());
  }

  @Test
  public void testGoingDownTriangleRight() throws Exception {
    String expected = String.format("  *%n **%n***%n");
    tp.goingDownTriangle(3, "right");
    assertEquals(expected, outContent.toString());
  }

  @Test
  public void testGoingDownTriangleLeft() throws Exception {
    String expected = String.format("***%n**%n*%n");
    tp.goingDownTriangle(3, "left");
    assertEquals(expected, outContent.toString());
  }

  @Test
  public void testTriangleContentRight() throws Exception {
    String expected = String.format(" **%n");
    tp.triangleContent(2, 3, "right");
    assertEquals(expected, outContent.toString());
  }

  @Test
  public void testTriangleContentLeft() throws Exception {
    String expected = String.format("**%n");
    tp.triangleContent(2, 3, "left");
    assertEquals(expected, outContent.toString());
  }
}