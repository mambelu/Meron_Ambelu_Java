package com.company.pointofsale;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IceCreamTest {
    @Test
    public void testIfSubtotalIworksPassingValueToTheQuantityAndPrice(){
        //Arrange
        IceCream myIcecreamObject = new IceCream();
        List<IceCream> myIcecreamList = new ArrayList<>();
        IceCream icecream1 = new IceCream();
        icecream1.setQuantity(2);
        icecream1.setPrice(3.50);

        IceCream icecream2 = new IceCream();
        icecream2.setQuantity(2);
        icecream2.setPrice(3.50);

        myIcecreamList.add(icecream1);
        myIcecreamList.add(icecream2);

        //Act
        double expectedOutput = 14.0;
        double actualOutput = myIcecreamObject.calculatetotalPrice(myIcecreamList);
        //Assert
        assertEquals(expectedOutput,actualOutput, 0.00001);


    }
    @Test
    public void testIfSubtotalIsCalculatedZeroIfIceceamsquantiyIsZero(){
        //Arrange
        IceCream myIcecreamObject = new IceCream();
        List<IceCream> myIcecreamList = new ArrayList<>();
        IceCream icecream1 = new IceCream();
        icecream1.setQuantity(0);

        IceCream icecream2 = new IceCream();
        icecream2.setQuantity(0);
        myIcecreamList.add(icecream1);
        myIcecreamList.add(icecream2);

        //Act
        double expectedOutput = 0.0;
        double actualOutput = myIcecreamObject.calculatetotalPrice(myIcecreamList);
        //Assert
        assertEquals(expectedOutput,actualOutput, 0.00001);


    }


}