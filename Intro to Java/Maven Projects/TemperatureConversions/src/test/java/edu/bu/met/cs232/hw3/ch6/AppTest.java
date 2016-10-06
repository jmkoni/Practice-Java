package edu.bu.met.cs232.hw3.ch6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the TemperatureConversions application.
 */
public class AppTest {
  private App tc;

  @Before
  public void setUp() throws Exception {
    tc = new App();
  }

  @After
  public void tearDown() throws Exception {
    tc = null;
  }

  @Test
  public void testSplitInput() throws Exception {
    String[] compareArray = {"22", "F"};
    assertArrayEquals(compareArray, tc.splitInput("22 F"));
  }

  @Test
  public void testCompareTempsF() throws Exception{
    assertTrue(tc.compareTemps("F", 59f, "59 F").equals(String.format("59 F is the same" +
        " as 15.0 C.%n")));
  }

  @Test
  public void testCompareTempsC() throws Exception{
    assertTrue(tc.compareTemps("C", 0f, "0 C").equals(String.format("0 C is the same" +
        " as 32.0 F.%n")));
  }

  @Test
  public void testCelsius() throws Exception {
    assertEquals(15.0f, tc.celsius(59f), 0.0001f);
  }

  @Test
  public void testFahrenheit() throws Exception {
    assertEquals(32.0f, tc.fahrenheit(0f), 0.0001f);
  }
}