package edu.bu.met.cs232.hw4.ch9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jmkoni on 2/27/16.
 */
public class SalariedEmployeeTest {
  SalariedEmployee employee;

  @Before
  public void setUp() throws Exception {
    employee = new SalariedEmployee("Rainbow", "Bright", "999-99-9999", 150.00);
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
  public void testSetWeeklySalary() throws Exception {
    employee.setWeeklySalary(500.00);
    assertEquals(500.0, employee.getWeeklySalary(), 0.01);
  }

  @Test
  public void testGetWeeklySalary() throws Exception {
    assertEquals(150.0, employee.getWeeklySalary(), 0.01);
  }

  @Test
  public void testEarnings() throws Exception {
    assertEquals(7800.0, employee.earnings(), 0.01);
  }

  @Test
  public void testToString() throws Exception {
    String expectedOutput = String.format("salaried employee: Rainbow Bright\n" +
        "social security number: 999-99-9999\n" +
        "weekly salary: 150.00\n");
    assertTrue(employee.toString().equals(expectedOutput));
  }
}