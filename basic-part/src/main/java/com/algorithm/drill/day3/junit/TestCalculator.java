package com.algorithm.drill.day3.junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculator {
    private static Calculator calculator = new Calculator();

    @Before
    public void setUp() throws Exception {
        calculator.clear();
    }

    @Test
    public void testAdd() {
        calculator.add(2);
        calculator.add(3);
        System.out.println("testAdd");
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void testSubstract() {
        System.out.println("testSubstract");
        calculator.add(10);
        calculator.substract(2);
        assertEquals(8, calculator.getResult());
    }

    @Test
    public void testMultiply() {
        System.out.println("testMultiply");
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());
    }

    @Test
    public void testSquare() {
        System.out.println("testSquare");
    }

    @Test(timeout = 10000)
    public void testSquareRoot() {
        calculator.squareRoot(4);
        assertEquals(2, calculator.getResult());
    }

}
