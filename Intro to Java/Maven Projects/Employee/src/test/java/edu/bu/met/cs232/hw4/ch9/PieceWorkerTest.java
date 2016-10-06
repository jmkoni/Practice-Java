package edu.bu.met.cs232.hw4.ch9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jmkoni on 2/27/16.
 */
public class PieceWorkerTest {
  PieceWorker employee;

  @Before
  public void setUp() throws Exception {
    employee = new PieceWorker("Rainbow", "Bright", "999-99-9999", 150.00, 3);
  }

  @After
  public void tearDown() throws Exception {
    employee = null;
  }

  @Test
  public void testGetFirstName() throws Exception {
    assertTrue(employee.getFirstName().equals("Rainbow"));
  }

  @Test
  public void testGetLastName() throws Exception {
    assertTrue(employee.getLastName().equals("Bright"));
  }

  @Test
  public void testGetSocialSecurityNumber() throws Exception {
    assertTrue(employee.getSocialSecurityNumber().equals("999-99-9999"));
  }

  @Test
  public void testSetWagePerPiece() throws Exception {
    employee.setWage(500.00);
    assertEquals(500.0, employee.getWage(), 0.01);
  }

  @Test
  public void testGetWagePerPiece() throws Exception {
    assertEquals(150.0, employee.getWage(), 0.01);
  }

  @Test
  public void testSetPiecesMade() throws Exception {
    employee.setPieces(2);
    assertTrue(2 == employee.getPieces());
  }

  @Test
  public void testGetPiecesMade() throws Exception {
    assertTrue(3 == employee.getPieces());
  }

  @Test
  public void testEarnings() throws Exception {
    assertEquals(450.0, employee.earnings(), 0.01);
  }

  @Test
  public void testToString() throws Exception {
    String expectedOutput = String.format("piece worker employee: Rainbow Bright\n" +
        "social security number: 999-99-9999\n" +
        "wage per piece: 150.00\n" +
        "pieces made: 3\n");
    assertTrue(employee.toString().equals(expectedOutput));
  }
}