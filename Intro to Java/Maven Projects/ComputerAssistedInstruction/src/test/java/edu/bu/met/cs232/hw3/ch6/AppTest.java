package edu.bu.met.cs232.hw3.ch6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the ComputerAssistedInstruction application.
 */

public class AppTest {
  private App cai;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    cai = new App();
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void tearDown() throws Exception {
    cai = null;
    System.setOut(null);
  }

  @Test
  public void testPrintProblemAddition() {
    int result = cai.printProblem(1,1,1);
    assertEquals(2, result);
    assertEquals("1 + 1 = ? ", outContent.toString());
  }

  @Test
  public void testPrintProblemMultiplication() {
    int result = cai.printProblem(1,2,3);
    assertEquals(2, result);
    assertEquals("1 * 2 = ? ", outContent.toString());
  }

  @Test
  public void testPrintProblemSubtraction() {
    int result = cai.printProblem(1,2,2);
    assertEquals(-1, result);
    assertEquals("1 - 2 = ? ", outContent.toString());
  }

  @Test
  public void testPrintProblemDivision() {
    int result = cai.printProblem(1,2,4);
    assertEquals(0, result);
    assertEquals("1 / 2 = ? ", outContent.toString());
  }

  @Test
  public void testPrintOutDaysSingles() throws Exception {
    int randNum = cai.getRandom(1);
    assertTrue(randNum < 10);
  }

  @Test
  public void testGenerateCommentTrue() throws Exception {
    String[] correctResponses = {"Very good!","Excellent!","Nice work!", "Keep up the " +
        "good work!"};
    assertTrue(Arrays.asList(correctResponses).contains(cai.generateComment(true)));
  }

  @Test
  public void testGenerateCommentFalse() throws Exception {
    String[] wrongResponses = { "No. Please try again.", "Wrong. Try once more.",
        "Don't give up!", "No. Keep trying."};
    assertTrue(Arrays.asList(wrongResponses).contains(cai.generateComment(false)));
  }

  @Test
  public void testCompareAnswers() throws Exception {
    assertTrue(cai.compareAnswer(1,1));
  }

  @Test
  public void testAddition() throws Exception {
    assertEquals(6, cai.addition(4,2));
  }

  @Test
  public void testMultiplication() throws Exception {
    assertEquals(8, cai.multiplication(4,2));
  }

  @Test
  public void testSubtraction() throws Exception {
    assertEquals(2, cai.subtraction(4,2));
  }

  @Test
  public void testDivision() throws Exception {
    assertEquals(2, cai.division(4,2));
  }
}