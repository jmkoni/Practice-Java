package edu.bu.met.cs232.hw4;

import junit.framework.TestCase;
import org.junit.rules.ExpectedException;
import static org.assertj.core.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class CatchingExceptionsWithSuperclassesTest
    extends TestCase
{

  @org.junit.Rule
  public final ExpectedException exception = ExpectedException.none();

  @org.junit.Test
  public void testMain() throws Exception {
    exception.expect(ExceptionA.class);
    CatchingExceptionsWithSuperclasses.main(new String[] {});
  }

  @org.junit.Test
  public void testMethod1() throws Exception {
    assertThatExceptionOfType(ExceptionA.class).isThrownBy(() -> {
      CatchingExceptionsWithSuperclasses.method1();}).withMessage("Too many ponies at " +
        "this party.");
  }

  @org.junit.Test
  public void testMethod2() throws Exception {
    assertThatExceptionOfType(ExceptionB.class).isThrownBy(() -> {
      CatchingExceptionsWithSuperclasses.method2();}).withMessage("Too many bears at " +
        "this party.");
  }

  @org.junit.Test
  public void testMethod3() throws Exception {
    assertThatExceptionOfType(ExceptionC.class).isThrownBy(() -> {
      CatchingExceptionsWithSuperclasses.method3();}).withMessage("Too many cats at " +
        "this party.");
  }
}
