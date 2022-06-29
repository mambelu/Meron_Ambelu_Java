package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;
    @Before
    public void setUp(){
        calculator = new Calculator();
    }
    @Test
    public void shouldAddTwoPositiveIntegers(){
        int expectedOutput = 5;
        int actualOutput = calculator.add(3,2);
        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void shouldAddTwoNegativeIntegers(){
        int expectedOutput = -13;
        int actualOutput = calculator.add(-3,-10);
        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void shouldAddNegativeAndPositiveIntegers(){
        int expectedOutput = 4;
        int actualOutput = calculator.add(-4,8);
        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void shouldAddTwoPositiveDoubles(){
        double expectedOutput = 5.0;
        double actualOutput = calculator.add(3.0,2.0);
        assertEquals(expectedOutput, actualOutput,0.001);
    }
    @Test
    public void shouldAddTwoNegativeDoubles(){
        double expectedOutput = -13.0;
        double actualOutput = calculator.add(-3.0,-10.0);
        assertEquals(expectedOutput, actualOutput,0.001);
    }
    @Test
    public void shouldAddNegativeAndPositiveDoubles(){
        double expectedOutput = 4.0;
        double actualOutput = calculator.add(-4.0,8.0);
        assertEquals(expectedOutput, actualOutput,0.001);
    }



}