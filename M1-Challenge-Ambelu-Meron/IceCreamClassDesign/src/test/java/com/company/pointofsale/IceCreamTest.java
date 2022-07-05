package com.company.pointofsale;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IceCreamTest {

    private  IceCream myIcecreamObject;
    @Before
    public void setUp(){myIcecreamObject = new IceCream();
    }
    @Test
    public void shouldreturnTotalPrice(){

        List<IceCream> myIcecreamList = new ArrayList<>();
        IceCream icecream1 = new IceCream();
        icecream1.setQuantity(2);
        icecream1.setPrice(2.0);
        icecream1.setNoOfScoop(1);

        IceCream icecream2 = new IceCream();
        icecream2.setQuantity(2);
        icecream2.setPrice(2.0);
        icecream2.setNoOfScoop(1);

        myIcecreamList.add(icecream1);
        myIcecreamList.add(icecream2);

        //Act
        double expectedOutput = 9.84;
        double actualOutput = myIcecreamObject.calculatetotalPrice(myIcecreamList);
        //Assert
        assertEquals(expectedOutput,actualOutput, 0.001);


    }

    @Test
    public void shouldIncrementThepriceByone(){
        myIcecreamObject.setPrice(14.0);


        double expectedOutPut = 15.0;
//addTopping method should add 1 to the price
        myIcecreamObject.addTopping();

        double actualOutput = myIcecreamObject.getPrice();
        assertEquals(expectedOutPut, actualOutput, 0.0001);




    }



}