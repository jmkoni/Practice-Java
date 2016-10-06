package edu.bu.met.cs232.hw3.ch8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * SavingsAccountTest
 * Created by Jennifer Konikowski on 2/21/16.
 */
public class SavingsAccountTest {
  private SavingsAccount saver1;

  @Before
  public void setUp() throws Exception {
    saver1 = new SavingsAccount(100.0);
    SavingsAccount.modifyInterestRate(0.05);
  }

  @After
  public void tearDown() throws Exception {
    saver1 = null;
  }

  @Test
  public void testGetSavingsBalance() throws Exception {
    assertEquals(BigDecimal.valueOf(100.0), saver1.getSavingsBalance());
  }

  @Test
  public void testCalculateMonthlyInterest() throws Exception {
    saver1.calculateMonthlyInterest();
    assertEquals(BigDecimal.valueOf(100.42), saver1.getSavingsBalance());
  }

  @Test
  public void testModifyInterestRate() throws Exception {
    SavingsAccount.modifyInterestRate(0.10);
    assertEquals(BigDecimal.valueOf(0.1), SavingsAccount.getAnnualInterestRate());
  }

  @Test
  public void testGetAnnualInterestRate() throws Exception {
    assertEquals(BigDecimal.valueOf(0.05), SavingsAccount.getAnnualInterestRate());
  }
}