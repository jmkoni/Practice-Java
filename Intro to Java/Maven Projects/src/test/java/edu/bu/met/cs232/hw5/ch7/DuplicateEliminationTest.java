package edu.bu.met.cs232.hw5.ch7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jmkoni on 4/3/16.
 */
public class DuplicateEliminationTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @org.junit.Before
  public void setUp() throws Exception {
    System.setOut(new PrintStream(outContent));
  }

  @org.junit.After
  public void tearDown() throws Exception {
    System.setOut(null);
  }

  @org.junit.Test
  public void testMainWithNoDups() throws Exception {
    String data = "11\n55\n60\n45\n82";
    System.setIn(new ByteArrayInputStream(data.getBytes()));
    String expectedOutput = String.format("Please enter a number between 10 and 100, " +
        "inclusive: Please enter a number between 10 and 100, inclusive: Please enter a" +
        " number between 10 and 100, inclusive: Please enter a number between 10 and " +
        "100, inclusive: Please enter a number between 10 and 100, inclusive: Array: " +
        "[11, 55, 60, 45, 82]\n");
    DuplicateElimination.main(new String[] {});
    assertEquals(expectedOutput, outContent.toString());
  }

  @org.junit.Test
  public void testMainWithDups() throws Exception {
    String data = "11\n55\n55\n5\n60\n45\n82";
    System.setIn(new ByteArrayInputStream(data.getBytes()));
    String expectedOutput = String.format("Please enter a number between 10 and 100, " +
        "inclusive: Please enter a number between 10 and 100, inclusive: Please enter a" +
        " number between 10 and 100, inclusive: Please enter a number between 10 and " +
        "100, inclusive: Please enter a number between 10 and 100, inclusive: Please " +
        "enter a number between 10 and 100, inclusive: Please enter a number between 10" +
        " and 100, inclusive: Array: [11, 55, 60, 45, 82]\n");
    DuplicateElimination.main(new String[] {});
    assertEquals(expectedOutput, outContent.toString());
  }
}