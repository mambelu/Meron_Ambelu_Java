package com.company.factory;

import com.company.pointofsale.IceCream;
import org.junit.Test;

import static org.junit.Assert.*;

public class IceCreamTest {
    @Test
    public void testsIfZeroquantityOfIcecreamWillreturnTrue(){
        //Arrange
        com.company.factory.IceCream myIcecream = new com.company.factory.IceCream();
        IceCream icream = new IceCream();
        icream.setQuantity(0);
        //act
        boolean expectedOutPut = true;
        boolean actualOutput = myIcecream.restockIcecream(icream);
        //Assert
        assertEquals(expectedOutPut,actualOutput);

    }


}