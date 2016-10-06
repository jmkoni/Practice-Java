package edu.bu.met.cs232.hw5.ch7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by jmkoni on 4/5/16.
 */
public class SalesCommissionsTest {
  private SalesCommissions sc;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    sc = new SalesCommissions();
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void tearDown() throws Exception {
    sc = null;
    System.setOut(null);
  }

  @Test
  public void testGetFrequency() throws Exception {
    int[] expectedOutput = new int[] {0, 1, 1, 1, 1, 0, 1, 1, 13};
    assertArrayEquals(expectedOutput, sc.getFrequency());
  }

  @Test
  public void testGetWeeklyEarnings() throws Exception {
    int[] expectedOutput = new int[] {902755, 70663, 470, 3762, 88663, 308, 7645, 920, 1030, 1100, 2000, 560, 814, 1088, 41322, 74844, 74665, 831667, 650};
    assertArrayEquals(expectedOutput, sc.getWeeklyEarnings());
  }

  @Test
  public void testGetWeeklySales() throws Exception {
    int[] expectedOutput = new int[] {1002839, 78293, 300, 3958, 98293, 120, 8273, 800, 923, 1000, 2000, 400, 683, 987, 45692, 82938, 82739, 923853, 500};
    assertArrayEquals(expectedOutput, sc.getWeeklySales());
  }

  @Test
  public void testCalculateWeeklyEarnings() throws Exception {
    assertEquals(290, sc.calculateWeeklyEarnings(100));
  }

  @Test
  public void testCalculateAllWeeklyEarnings() throws Exception {
    int[] expectedOutput = new int[] {290,380,470};
    assertArrayEquals(expectedOutput, sc.calculateAllWeeklyEarnings(new int[] {100, 200,
        300}));
  }

  @Test
  public void testDetermineFrequency() throws Exception {
    int[] expectedOutput = new int[] {2,1,0,0,0,0,0,0,0};
    assertArrayEquals(expectedOutput, sc.determineFrequency(new int[] {100, 200,
        300}));
  }

  @Test
  public void testDisplayData() throws Exception {
    String expectedOutput = String.format("Amount        Number of Salespeople\n" +
        "-----------|-----------------------\n" +
        "$200-299             0\n" +
        "$300-399             1\n" +
        "$400-499             3\n" +
        "$500-599             5\n" +
        "$600-699             2\n" +
        "$700-799             0\n" +
        "$800-899             8\n" +
        "$900-999             2\n" +
        ">=$1,000             9\n");
    sc.displayData(new int[] {0, 1, 3, 5, 2, 0, 8, 2, 9});
    assertEquals(expectedOutput, outContent.toString());
  }
}