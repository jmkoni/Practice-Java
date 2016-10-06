package edu.bu.met.cs232.hw3.ch6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the GreatestCommonDivisor application.
 */
public class AppTest {
    private App gcd;

    @Before
    public void setUp() throws Exception {
        gcd = new App();
    }

    @After
    public void tearDown() throws Exception {
        gcd = null;
    }

    @Test
    public void testEuclid() throws Exception {
        assertEquals(9, gcd.euclid(36,81));
    }
}
