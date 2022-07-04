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
    public void shouldAddTwoInts(){

        assertEquals(4,calculator.add(2,2));
        assertEquals(-5,calculator.add(-10,5));
        assertEquals(-4,calculator.add(-2,-2));
    }
    @Test
    public void shouldAddTwoDoubles(){

        assertEquals(4.5,calculator.add(2.5,2),0.001);
        assertEquals(-5.5,calculator.add(-10.5,5),0.001);
        assertEquals(-4.8,calculator.add(-2.5,-2.3),0.001);
    }
    @Test
    public void shouldReturnDifferenceOfTwoInts(){

        assertEquals(0,calculator.subtract(2,2));
        assertEquals(-15,calculator.subtract(-10,5));
        assertEquals(0,calculator.subtract(-2,-2));
    }
    @Test
    public void shouldReturnDifferenceOfTwoDoubles(){

        assertEquals(0.5,calculator.subtract(2.5,2),0.001);
        assertEquals(-15.5,calculator.subtract(-10.5,5),0.001);
        assertEquals(-0.2,calculator.subtract(-2.5,-2.3),0.001);
    }

    @Test
    public void shouldMultiplyTwoInts(){

        assertEquals(16,calculator.multiply(8,2));
        assertEquals(-50,calculator.multiply(-10,5));
        assertEquals(4,calculator.multiply(-2,-2));
    }
    @Test
    public void shouldMultiplyTwoDoubles(){

        assertEquals(5.0,calculator.multiply(2.5,2),0.001);
        assertEquals(-105.0,calculator.multiply(-10.5,10),0.001);
        assertEquals(4.0,calculator.multiply(-2.0,-2.0),0.001);
    }

    @Test
    public void shouldDivideTwoInts(){

        assertEquals(4,calculator.divide(8,2));
        assertEquals(-2,calculator.divide(-10,5));
        assertEquals(1,calculator.divide(-2,-2));
    }
    @Test
    public void shoulDivideTwoDoubles(){

        assertEquals(2.5,calculator.divide(5.0,2.0),0.001);
        assertEquals(-1.05,calculator.divide(-10.5,10),0.001);
        assertEquals(1.0,calculator.divide(-2.0,-2.0),0.001);
    }







}