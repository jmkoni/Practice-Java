package edu.bu.met.cs232.hw4.ch10;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * HourlyEmployeeTest
 * Created by jmkoni on 3/4/16.
 */
public class HourlyEmployeeTest {
  HourlyEmployee employee;

  @Before
  public void setUp() throws Exception {
    employee = new HourlyEmployee("Rainbow", "Bright", "999-99-9999", 5, 16, 1980,
        20.00, 42.00);
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
  public void testGetBirthDate() throws Exception {
    DateTime birthDate = new DateTime(1980, 5, 16, 0, 0);
    assertEquals(birthDate, employee.getBirthDate());
  }

  @Test
  public void testSetHoursWorked() throws Exception {
    employee.setHours(30.00);
    assertEquals(30.0, employee.getHours(), 0.01);
  }

  @Test
  public void testGetHoursWorked() throws Exception {
    assertEquals(42.0, employee.getHours(), 0.01);
  }

  @Test
  public void testGetHourlyWage() throws Exception {
    assertEquals(20.0, employee.getWage(), 0.01);
  }

  @Test
  public void testSetHourlyWage() throws Exception {
    employee.setWage(30.00);
    assertEquals(30.0, employee.getWage(), 0.01);
  }

  @Test
  public void testEarnings() throws Exception {
    assertEquals(860.0, employee.earnings(), 0.01);
  }

  @Test
  public void getPaymentAmount() throws Exception {
    assertEquals(860.0, employee.getPaymentAmount(), 0.01);
  }

  @Test
  public void testToString() throws Exception {
    String expectedOutput = String.format("hourly employee: Rainbow Bright\n" +
        "social security number: 999-99-9999\n" +
        "hourly wage: $20.00\nhours worked: 42.0\n");
    assertEquals(expectedOutput, employee.toString());
  }
}
