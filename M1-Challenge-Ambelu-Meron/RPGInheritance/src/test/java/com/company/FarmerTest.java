package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmerTest {
    private Farmer character;
    private Character otherChar;
    @Before
    public void setUp(){
        character = new Farmer();

        otherChar = new Farmer();
    }
    @Test
    public void shouldReduceTheHealthAndStrengthOfInputCharacterWhenAttacked(){

        otherChar.setHealth(85);
        otherChar.setStrength(100);
        character.attackAnotherCharacter(otherChar);
        assertEquals(84,otherChar.getHealth());
        assertEquals(99,otherChar.getStrength());


    }

    @Test
    public void TestsIfStrengthAndHealthRemainTheSameWhenAttackPowerIsZero(){

        otherChar.setHealth(85);
        otherChar.setStrength(100);
        character.setAttackPower1(0);
        character.attackAnotherCharacter(otherChar);
        assertEquals(85,otherChar.getHealth());
        assertEquals(100,otherChar.getStrength());


    }

}