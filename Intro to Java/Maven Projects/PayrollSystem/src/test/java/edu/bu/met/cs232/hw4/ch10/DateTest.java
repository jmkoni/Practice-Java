package edu.bu.met.cs232.hw4.ch10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//
//import java.time.LocalDateTime;
//
//import static org.junit.Assert.*;
//
///**
// * Created by jmkoni on 2/27/16.
// */
//public class DateTest {
//  Date testDate;
//  @Before
//  public void setUp() throws Exception {
//    testDate = new Date(4, 29, 1987);
//  }
//
//  @After
//  public void tearDown() throws Exception {
//    testDate = null;
//  }
//
//  @Test
//  public void testGetMonth() throws Exception {
//    assertEquals(4, testDate.getMonth());
//  }
//
//  @Test
//  public void testGetDay() throws Exception {
//    assertEquals(29, testDate.getDay());
//  }
//
//  @Test
//  public void testGetYear() throws Exception {
//    assertEquals(1987, testDate.getYear());
//  }
//
//  @Test
//  public void testToString() throws Exception {
//    assertTrue(testDate.toString().equals("4/29/1987"));
//  }
//
//  @Test
//  public void testToday() throws Exception {
//    LocalDateTime currentDay = LocalDateTime.now();
//    Date today = Date.today();
//    assertTrue(today.getMonth() == currentDay.getMonthValue() && today.getDay() ==
//        currentDay.getDayOfMonth() && today.getYear() == currentDay.getYear());
//  }
//}