package edu.bu.met.cs232.hw5.ch16;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * PrimeNumberTest
 * Created by jmkoni on 4/5/16.
 *
 * This tests the PrimeNumber app
 */
public class PrimeNumberTest {
  PrimeNumber pm;

  @Before
  public void setUp() throws Exception {
    pm = new PrimeNumber(99);
  }

  @After
  public void tearDown() throws Exception {
    pm = null;
  }

  @Test
  public void testDeterminePrimeFactors() throws Exception {
    HashSet<Integer> expectedOuput = new HashSet<Integer>();
    expectedOuput.add(3);
    expectedOuput.add(11);
    assertThat(expectedOuput, is(pm.determinePrimeFactors()));
  }

  @Test
  public void testDetermineIfPrimeTrue() throws Exception {
    pm = new PrimeNumber(23);
    assertTrue(pm.determineIfPrime());
  }

  @Test
  public void testDetermineIfPrimeFalse() throws Exception {
    assertFalse(pm.determineIfPrime());
  }

  @Test
  public void testReturnTextPrimesIfPrime() throws Exception {
    pm = new PrimeNumber(23);
    String expectedOutput = "This is a prime number!";
    assertEquals(expectedOutput, pm.returnTextPrimes());
  }

  @Test
  public void testReturnTextPrimesIfNotPrime() throws Exception {
    String expectedOutput = "This is not a prime number, here are the factors: \n" +
        "[3, 11]";
    assertEquals(expectedOutput, pm.returnTextPrimes());
  }
}