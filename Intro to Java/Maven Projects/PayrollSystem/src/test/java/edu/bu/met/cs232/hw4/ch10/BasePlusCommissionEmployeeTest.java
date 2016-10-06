package edu.bu.met.cs232.hw4.ch10;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * BasePlusCommissionEmployeeTest
 * Created by jmkoni on 3/4/16.
 */
public class BasePlusCommissionEmployeeTest {
  BasePlusCommissionEmployee employee;

  @org.junit.Before
  public void setUp() throws Exception {
    employee = new BasePlusCommissionEmployee("Rainbow", "Bright", "999-99-9999", 3, 2,
        1985, 100.0, 0.50, 20000.00);
  }

  @org.junit.After
  public void tearDown() throws Exception {
    employee = null;
  }

  @org.junit.Test
  public void testSetBaseSalary() throws Exception {
    employee.setBaseSalary(10000.00);
    assertEquals(10000.00, employee.getBaseSalary(), 0.01);
  }

  @org.junit.Test
  public void testGetBaseSalary() throws Exception {
    assertEquals(20000.00, employee.getBaseSalary(), 0.01);
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
    DateTime birthDate = new DateTime(1985, 3, 2, 0, 0);
    assertEquals(birthDate, employee.getBirthDate());
  }

  @Test
  public void testSetGrossSales() throws Exception {
    employee.setGrossSales(500.00);
    assertEquals(500.0, employee.getGrossSales(), 0.01);
  }

  @Test
  public void testGetGrossSales() throws Exception {
    assertEquals(100.0, employee.getGrossSales(), 0.01);
  }

  @Test
  public void testSetCommissionRate() throws Exception {
    employee.setCommissionRate(0.10);
    assertEquals(0.10, employee.getCommissionRate(), 0.01);
  }

  @Test
  public void testGetCommissionRate() throws Exception {
    assertEquals(0.50, employee.getCommissionRate(), 0.01);
  }

  @Test
  public void testEarnings() throws Exception {
    assertEquals(20050.0, employee.earnings(), 0.01);
  }

  @Test
  public void testGetPaymentAmount() throws Exception {
    assertEquals(20050.0, employee.getPaymentAmount(), 0.01);
  }

  @Test
  public void testToString() throws Exception {
    String expectedOutput = String.format("base-salaried commission employee: Rainbow " +
        "Bright\nsocial security number: 999-99-9999\ngross sales: $100.00\n" +
        "commission rate: 0.50\nbase salary: $20,000.00\n");
    assertEquals(expectedOutput, employee.toString());
  }
}