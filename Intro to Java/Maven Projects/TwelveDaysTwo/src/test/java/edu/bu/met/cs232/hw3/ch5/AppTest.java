package edu.bu.met.cs232.hw3.ch5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the TwelveDays application.
 */

public class AppTest {
  private App td2;
  private ArrayList<String> testArray;
  private ArrayList<String> resultArray;

  @Before
  public void setUp() throws Exception {
    testArray = new ArrayList<String>();
    resultArray = new ArrayList<String>();
    td2 = new App();
  }

  @After
  public void tearDown() throws Exception {
    td2 = null;
    testArray = null;
    resultArray = null;
  }

  @Test
  public void testAssignDaysAndGifts() throws Exception {
    testArray.add("ninth");
    testArray.add("nine lords a-leaping");
    resultArray = td2.assignDaysAndGifts(9);
    assertEquals(testArray, resultArray);
  }

  @Test
  public void testAssignDaysAndGiftsInvalid() throws Exception {
    testArray.add("not-really-a-day-of-Christmas");
    testArray.add("a lump of coal");
    resultArray = td2.assignDaysAndGifts(20);
    assertEquals(testArray, resultArray);
  }
}
