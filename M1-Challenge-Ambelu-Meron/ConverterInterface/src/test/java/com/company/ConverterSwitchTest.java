package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterSwitchTest {

    ConverterSwitch converter;
    @Before
    public void setUp(){
        converter = new ConverterSwitch();
    }

    @Test
    public void shouldConvertsGivenNumberToCorrespondingMonth(){
        //Act
        String expectedOutPut = "January";
        String actualOutput = converter.convertMonth(1);
        //Assert
        assertEquals(expectedOutPut,actualOutput);


    }

    @Test
    public void shouldConvertsGivenNumberToCorrespondingDay(){
        //Act
        String expectedOutPut = "Wednesday";
        String actualOutput = converter.convertDay(4);
        //Assert
        assertEquals(expectedOutPut,actualOutput);


    }


}