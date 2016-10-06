package edu.bu.met.cs232.h3.ch6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * edu.bu.met.cs232.h3.ch6.AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * Tests the ParkingCharges application
 */

public class AppTest {
  App pc;

  @Before
  public void setUp() throws Exception {
    pc = new App();
  }

  @After
  public void tearDown() throws Exception {
    pc = null;
  }

  @Test
  public void testCalculateChargesMinimum() throws Exception {
    assertEquals(2.00f, pc.calculateCharges(2), .0001f);
  }

  @Test
  public void testCalculateChargesMaximum() throws Exception {
    assertEquals(10.00f, pc.calculateCharges(24), .0001f);
  }

  @Test
  public void testCalculateChargesMiddle() throws Exception {
    assertEquals(3.50f, pc.calculateCharges(7), .0001f);
  }
}