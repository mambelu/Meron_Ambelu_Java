package com.company.factory;

import com.company.pointofsale.IceCream;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IceCreamTest {

    private  com.company.factory.IceCream myIcecream ;

    @Before
    public void setUp(){myIcecream = new com.company.factory.IceCream();
    }
    @Test
    public void ShouldReturnTrueForIcecreamAtSalePointQantityZero(){
        //Arrange

        IceCream pointOfSaleIcecream = new IceCream();
        pointOfSaleIcecream.setQuantity(0);
        //act
        boolean expectedOutPut = true;
        boolean actualOutput = myIcecream.restockIcecream(pointOfSaleIcecream);
        //Assert
        assertEquals(expectedOutPut,actualOutput);

    }

    @Test
    public void ShouldReturnTrueForIcecreamWithPeanutInTheIngrediant(){
        //Arrange
        com.company.factory.IceCream icecream1 = new com.company.factory.IceCream();
        List<String> ingredientList = new ArrayList<>();
        ingredientList.add("peanut");
        icecream1.setIngredients(ingredientList);

        //act
        boolean expectedOutPut = true;
        boolean actualOutput = icecream1.isallergyCaution();
        //Assert
        assertEquals(expectedOutPut,actualOutput);

    }
    @Test
    public void shouldReturnProfit(){
        myIcecream.setProductionCost(1.0); //per ice cream
        myIcecream.setSalePrice(3.0); // per ice cream

        double expectedOutput = 2.0;

        double actualOutput = myIcecream.calculateProfit();

        //Assert
        assertEquals(expectedOutput,actualOutput, 0.0001);
    }


}