package edu.bu.met.cs232.hw3.ch5;

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
  private App cs;

  @Before
  public void setUp() throws Exception {
    cs = new App();
  }

  @After
  public void tearDown() throws Exception {
    cs = null;
  }

  @Test
  public void testGetProductPrice() throws Exception {
    assertEquals(2.98f, cs.getProductPrice(1), 0.01);
  }

  @Test
  public void testGetProductPriceNull() throws Exception{
    assertEquals(0.1f, cs.getProductPrice(8), 0.01);
  }
}
