package edu.bu.met.cs232.hw4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by jmkoni on 3/19/16.
 */
public class SomeClassTest {
  @Test
  public void testSomeClass() throws Exception {
    assertThatExceptionOfType(ExceptionA.class).isThrownBy(() -> {
      new SomeClass();}).withMessage("Too many ponies at " +
        "this party.");
  }
}