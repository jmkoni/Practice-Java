package edu.bu.met.cs232.hw4.ch10;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jmkoni on 3/19/16.
 */
public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @org.junit.Test
    public void testMain() throws Exception {
        String expectedOutput = "*---------------------*\n" +
            "* PAYROLL SYSTEM TEST *\n" +
            "*---------------------*\n" +
            "Employees processed polymorphically:\n" +
            "\n" +
        "salaried employee: Kevin Konikowski\n" +
        "social security number: 999-99-9999\n" +
        "weekly salary: $2,000.00\n" +
        "earned $8,100.00\n" +
            "\n" +
        "hourly employee: Karen Price\n" +
        "social security number: 222-22-2222\n" +
        "hourly wage: $16.75\n" +
        "hours worked: 40.0\n" +
        "earned $2,680.00\n" +
            "\n" +
        "commission employee: Sue Jones\n" +
        "social security number: 333-33-3333\n" +
        "gross sales: $10,000.00\n" +
        "commission rate: 0.06\n" +
        "earned $2,400.00\n" +
            "\n" +
        "base-salaried commission employee: Bob Lewis\n" +
        "social security number: 444-44-4444\n" +
        "gross sales: $5,000.00\n" +
        "commission rate: 0.04\n" +
        "base salary: $300.00\n" +
        "earned $2,000.00\n" +
            "\n" +
        "piece worker employee: Rainbow Bright\n" +
        "social security number: 111-11-1111\n" +
        "wage per piece: 20.00\n" +
        "pieces made: 100\n" +
        "earned $8,000.00\n" +
            "\n" +
            "\n" +
            "*------------------------------*\n" +
        "* ACCOUNTS PAYABLE SYSTEM TEST *\n" +
        "*------------------------------*\n" +
            "Invoices and Employees processed polymorphically:\n" +
            "\n" +
        "invoice:\n" +
        "part number: 01234 (seat)\n" +
            "quantity: 2\n" +
        "price per item: $375.00\n" +
        "payment due: $750.00\n" +
            "\n" +
        "invoice:\n" +
        "part number: 56789 (tire)\n" +
            "quantity: 4\n" +
        "price per item: $79.95\n" +
        "payment due: $319.80\n" +
            "\n" +
        "salaried employee: Kevin Konikowski\n" +
        "social security number: 999-99-9999\n" +
        "weekly salary: $2,000.00\n" +
        "payment due: $2,000.00\n" +
            "\n" +
        "hourly employee: Karen Price\n" +
        "social security number: 222-22-2222\n" +
        "hourly wage: $16.75\n" +
        "hours worked: 40.0\n" +
        "payment due: $670.00\n" +
            "\n" +
        "commission employee: Sue Jones\n" +
        "social security number: 333-33-3333\n" +
        "gross sales: $10,000.00\n" +
        "commission rate: 0.06\n" +
        "payment due: $600.00\n" +
            "\n" +
        "new base salary with 10% increase is: $330.00\n" +
        "base-salaried commission employee: Bob Lewis\n" +
        "social security number: 444-44-4444\n" +
        "gross sales: $5,000.00\n" +
        "commission rate: 0.04\n" +
        "base salary: $330.00\n" +
        "payment due: $530.00\n" +
            "\n" +
        "piece worker employee: Rainbow Bright\n" +
        "social security number: 111-11-1111\n" +
        "wage per piece: 20.00\n" +
        "pieces made: 100\n" +
        "payment due: $2,000.00\n";
        App.main(new String[] {});
        assertEquals(expectedOutput, outContent.toString());
    }
}