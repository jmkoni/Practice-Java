package edu.bu.met.cs232.hw3.ch5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * AppTest.java
 * Created by Jennifer Konikowski on 2/18/16.
 *
 * This file tests the TemperatureConversions application.
 */
public class AppTest {
    private App sv;

    @Before
    public void setUp() throws Exception {
        sv = new App();
    }

    @After
    public void tearDown() throws Exception {
        sv = null;
    }

    @Test
    public void testReturnSmallestIntGreater() throws Exception {
        assertEquals(2, sv.returnSmallestInt(5,2));
    }

    @Test
    public void testReturnSmallestIntLesser() throws Exception{
        assertEquals(3, sv.returnSmallestInt(3,6));
    }
}
