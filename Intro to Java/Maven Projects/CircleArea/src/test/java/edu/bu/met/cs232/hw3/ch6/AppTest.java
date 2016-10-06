package edu.bu.met.cs232.hw3.ch6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the CircleArea application.
 */
public class AppTest {
  private App ca;

  @Before
  public void setUp() throws Exception {
    ca = new App();
  }

  @After
  public void tearDown() throws Exception {
    ca = null;
  }

  @Test
  public void testCircleArea() throws Exception {
    assertEquals(12.5663f, ca.circleArea(2), 0.001f);
  }
}