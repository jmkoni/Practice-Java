package edu.bu.met.cs232.hw5.ch16;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * DuplicateWordsTest
 * Created by jmkoni on 4/5/16.
 *
 * This tests DuplicateWords
 */
public class DuplicateWordsTest {
  private DuplicateWords dw;

  @Before
  public void setUp() throws Exception {
    dw = new DuplicateWords("This sentence is a test of a test of a test.");
  }

  @After
  public void tearDown() throws Exception {
    dw = null;
  }

  @Test
  public void testGetNumWords() throws Exception {
    HashMap<String, Integer> dups = dw.getNumWords();
    assertTrue(dups.get("test") == 3);
  }

  @Test
  public void testDetermineDups() throws Exception {
    LinkedList<String> expectedOutput = new LinkedList<String>();
    expectedOutput.add("a");
    expectedOutput.add("test");
    expectedOutput.add("of");
    assertThat(expectedOutput, is(dw.determineDups()));
  }

  @Test
  public void testPrettyPrintWordNums() throws Exception {
    String expectedOutput = "\n" +
        "\"sentence\" occurs 1 times.\n" +
        "\"a\" occurs 3 times.\n" +
        "\"test\" occurs 3 times.\n" +
        "\"of\" occurs 2 times.\n" +
        "\"this\" occurs 1 times.\n" +
        "\"is\" occurs 1 times.";
    assertEquals(expectedOutput, dw.prettyPrintWordNums());
  }

  @Test
  public void testPrettyPrintDups() throws Exception {
    String expectedOutput = "Duplicated words:  a, test, of";
    assertEquals(expectedOutput, dw.prettyPrintDups());
  }
}