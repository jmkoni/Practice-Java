package edu.bu.met.cs232.hw3.ch6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the GuessTheNumber application.
 */
public class AppTest {
  private App gtn;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    System.setOut(new PrintStream(outContent));
    gtn = new App();
  }

  @After
  public void tearDown() throws Exception {
    gtn = null;
    System.setOut(null);
  }

  @Test
  public void testGuessEvaluatorHigh() throws Exception {
    gtn.guessEvaluator(2,4);
    assertEquals("Too high. Try again.\n", outContent.toString());
  }

  @Test
  public void testGuessEvaluatorLow() throws Exception {
    gtn.guessEvaluator(4,2);
    assertEquals("Too low. Try again.\n", outContent.toString());
  }

  @Test
  public void testGuessEvaluatorCorrect() throws Exception {
    gtn.guessEvaluator(4,4);
    assertEquals("Congratulations. You guessed the number!\n", outContent.toString());
  }
}

