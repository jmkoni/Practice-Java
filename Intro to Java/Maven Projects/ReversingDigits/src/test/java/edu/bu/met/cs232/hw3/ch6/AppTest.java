package edu.bu.met.cs232.hw3.ch6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the ReversingDigits application.
 */
public class AppTest {
    private App rd;

    @Before
    public void setUp() throws Exception {
        rd = new App();
    }

    @After
    public void tearDown() throws Exception {
        rd = null;
    }

    @Test
    public void testReverseDigits() throws Exception {
        assertEquals(8731, rd.reverseDigits(1378));
    }
}
