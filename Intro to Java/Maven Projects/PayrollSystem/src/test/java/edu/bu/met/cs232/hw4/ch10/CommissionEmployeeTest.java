package edu.bu.met.cs232.hw4.ch10;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * CommissionEmployeeTest
 * Created by jmkoni on 3/4/16.
 */
public class CommissionEmployeeTest {
  CommissionEmployee employee;

  @Before
  public void setUp() throws Exception {
    employee = new CommissionEmployee("Rainbow", "Bright", "999-99-9999", 8, 2, 1970,
        150.00, 0.60);
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
    DateTime birthDate = new DateTime(1970, 8, 2, 0, 0);
    assertEquals(birthDate, employee.getBirthDate());
  }

  @Test
  public void testSetGrossSales() throws Exception {
    employee.setGrossSales(500.00);
    assertEquals(500.0, employee.getGrossSales(), 0.01);
  }

  @Test
  public void testGetGrossSales() throws Exception {
    assertEquals(150.0, employee.getGrossSales(), 0.01);
  }

  @Test
  public void testSetCommissionRate() throws Exception {
    employee.setCommissionRate(0.10);
    assertEquals(0.10, employee.getCommissionRate(), 0.01);
  }

  @Test
  public void testGetCommissionRate() throws Exception {
    assertEquals(0.60, employee.getCommissionRate(), 0.01);
  }

  @Test
  public void testEarnings() throws Exception {
    assertEquals(90.0, employee.earnings(), 0.01);
  }

  @Test
  public void testGetPaymentAmount() throws Exception {
    assertEquals(90.0, employee.getPaymentAmount(), 0.01);
  }

  @Test
  public void testToString() throws Exception {
    String expectedOutput = String.format("commission employee: Rainbow Bright\n" +
        "social security number: 999-99-9999\n" +
        "gross sales: $150.00\n" +
        "commission rate: 0.60\n");
    assertEquals(expectedOutput, employee.toString());
  }
}
