package edu.bu.met.cs232.hw5.ch16;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * DuplicateEliminationTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the DuplicateElimination application.
 */
public class DuplicateEliminationTest {
  private DuplicateElimination dup;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    dup = new DuplicateElimination();
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void tearDown() throws Exception {
    dup = null;
    System.setOut(null);
  }

  @Test
  public void testSplitStringToArray() throws Exception {
    String[] expectedOutput = {"Kara", "Oliver", "April"};
    assertArrayEquals(expectedOutput, dup.splitStringToArray("Kara, Oliver, April"));
  }

  @Test
  public void testRemoveDups() throws Exception {
    String[] expectedArray = {"Kara", "Oliver", "April"};
    Set expectedOutput = new HashSet<String>(Arrays.asList(expectedArray));
    dup = new DuplicateElimination("Kara, Kara, Oliver, Kara, April");
    assertEquals(expectedOutput, dup.getUniqueFirstNames());
  }

  @Test
  public void testShowSearchResultsTrue() throws Exception {
    dup.showSearchResults("Kara");
    assertEquals("Yay, Kara is in the list of names.", outContent.toString());
  }

  @Test
  public void testShowSearchResultsFalse() throws Exception {
    dup.showSearchResults("Toby");
    assertEquals("Sorry, Toby is not in the list of names.", outContent.toString());
  }

  @Test
  public void testSearchFirstNames() throws Exception {
    assertTrue(dup.searchFirstNames("Kara"));
  }

  @Test
  public void testSearchFirstNamesFalse() throws Exception {
    assertFalse(dup.searchFirstNames("Toby"));
  }
}