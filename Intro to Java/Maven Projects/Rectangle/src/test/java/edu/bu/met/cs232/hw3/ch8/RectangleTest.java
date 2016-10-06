package edu.bu.met.cs232.hw3.ch8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * RectangleTest
 * Created by Jennifer Konikowski on 2/21/16.
 */
public class RectangleTest {
  private Rectangle basic;
  private Rectangle large;

  @Before
  public void setUp() throws Exception {
    basic = new Rectangle();
    large = new Rectangle(15.5f, 15.5f);
  }

  @After
  public void tearDown() throws Exception {
    basic = null;
    large = null;
  }

  @Test
  public void testGetLength() throws Exception {
    assertEquals(15.5f, large.getLength(), 0.1f);
    assertEquals(1.0f, basic.getLength(), 0.1f);
  }

  @Test
  public void testSetLengthValid() throws Exception {
    large.setLength(6.0f);
    assertEquals(6.0f, large.getLength(), 0.1f);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSetLengthInvalidNegative() throws Exception {
    large.setLength(-6.0f);
    assertEquals(15.5f, large.getLength(), 0.1f);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSetLengthInvalidTooLarge() throws Exception {
    large.setLength(25.0f);
    assertEquals(15.5f, large.getLength(), 0.1f);
  }

  @Test
  public void testGetWidth() throws Exception {
    assertEquals(15.5f, large.getWidth(), 0.1f);
    assertEquals(1.0f, basic.getWidth(), 0.1f);
  }

  @Test
  public void testSetWidthValid() throws Exception {
    large.setWidth(6.0f);
    assertEquals(6.0f, large.getWidth(), 0.1f);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSetWidthInvalidNegative() throws Exception {
    large.setWidth(-6.0f);
    assertEquals(15.5f, large.getWidth(), 0.1f);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSetWidthInvalidTooLarge() throws Exception {
    large.setWidth(25.0f);
    assertEquals(15.5f, large.getWidth(), 0.1f);
  }

  @Test
  public void testPerimeter() throws Exception {
    assertEquals(62.0f, large.perimeter(), 0.1f);
  }

  @Test
  public void testArea() throws Exception {
    assertEquals(240.25f, large.area(), 0.01f);
  }
}