package edu.bu.met.cs232.hw4;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by jmkoni on 3/19/16.
 */
public class RethrowingExceptionsTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    System.setErr(new PrintStream(outContent));
  }

  @After
  public void tearDown() throws Exception {
    System.setErr(null);
  }

  @org.junit.Test
  public void testMain() throws Exception {
    RethrowingExceptions.main(new String[] {});
    assertThat(outContent.toString(), containsString("edu.bu.met.cs232.hw4" +
        ".ExceptionC: Too many cats at this party."));
  }
}