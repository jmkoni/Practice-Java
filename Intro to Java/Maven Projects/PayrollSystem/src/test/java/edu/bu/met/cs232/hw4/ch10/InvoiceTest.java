package edu.bu.met.cs232.hw4.ch10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * InvoiceTest
 * Created by jmkoni on 3/4/16.
 */
public class InvoiceTest {
  private Invoice invoice;
  @Before
  public void setUp() throws Exception {
    // double rainbows are priceless
    invoice = new Invoice("1234", "RAINBOWS", 2, 100000.00);
  }

  @After
  public void tearDown() throws Exception {
    invoice = null;
  }

  @Test
  public void testGetPartNumber() throws Exception {
    assertEquals("1234", invoice.getPartNumber());
  }

  @Test
  public void testGetPartDescription() throws Exception {
    assertEquals("RAINBOWS", invoice.getPartDescription());
  }

  @Test
  public void testSetQuantity() throws Exception {
    invoice.setQuantity(4);
    assertEquals(4, invoice.getQuantity());
  }

  @Test
  public void testGetQuantity() throws Exception {
    assertEquals(2, invoice.getQuantity());
  }

  @Test
  public void testSetPricePerItem() throws Exception {
    invoice.setPricePerItem(10.00);
    assertEquals(10.0, invoice.getPricePerItem(), 0.01);
  }

  @Test
  public void testGetPricePerItem() throws Exception {
    assertEquals(100000.00, invoice.getPricePerItem(), 0.01);
  }

  @Test
  public void testToString() throws Exception {
    assertEquals("invoice: \npart number: 1234 (RAINBOWS) \nquantity: 2 \n" +
        "price per item: $100,000.00\n", invoice.toString());
  }

  @Test
  public void testGetPaymentAmount() throws Exception {
    assertEquals(200000.00, invoice.getPaymentAmount(), 0.01);
  }
}