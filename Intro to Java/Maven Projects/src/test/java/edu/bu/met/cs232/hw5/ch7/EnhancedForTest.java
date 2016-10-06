package edu.bu.met.cs232.hw5.ch7;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jmkoni on 4/3/16.
 */
public class EnhancedForTest {
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
  public void testMain() throws Exception {
    String expectedOutput = String.format("Total of all numbers: 29.6\n");
    EnhancedFor.main(new String[] {"8.0","3.0","5.5","8.2","4.9"});
    assertEquals(expectedOutput, outContent.toString());
  }
}