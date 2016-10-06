package edu.bu.met.cs232.hw3.ch5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the TwelveDays application.
 */

public class AppTest {
  private App td = new App();
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private HashMap<Integer, String[]> testGifts = new HashMap<Integer, String[]>();

  @Before
  public void setUp() throws Exception {
    System.setOut(new PrintStream(outContent));
    String[] first = {"first", "a unicorn"};
    String[] second = {"second", "two whales"};
    String[] third = {"third", "three narwhals"};
    String[] fourth = {"fourth", "four ponies"};
    testGifts.put(1, first);
    testGifts.put(2, second);
    testGifts.put(3, third);
    testGifts.put(4, fourth);
  }

  @After
  public void tearDown() throws Exception {
    testGifts = null;
    td = null;
    System.setOut(null);
  }

  @Test
  public void testPrintOutDays() throws Exception {
    String expected_output = String.format("On the first day of Christmas, my true love sent to me a unicorn.\n" +
        "On the second day of Christmas, my true love sent to me two whales and a unicorn.\n" +
        "On the third day of Christmas, my true love sent to me three narwhals, two whales and a unicorn.\n" +
        "On the fourth day of Christmas, my true love sent to me four ponies, three" +
        " narwhals, two whales and a unicorn.\n");
    td.printOutDays(testGifts);
    assertEquals(expected_output, outContent.toString());
  }
}
