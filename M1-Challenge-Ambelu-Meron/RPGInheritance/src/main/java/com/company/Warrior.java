package com.company;

public class Warrior extends Character{
    private int shieldStrength;

    public Warrior( int shieldStrength, String name,int strength,int health,int stamina,int speed,int attackPower,boolean running,boolean arrested) {
        super(name,strength,health,stamina,speed,attackPower,running,arrested);
        this.strength=75;
        this.health=100;
        this.stamina=100;
        this.speed=50;
        this.attackPower=10;
        this.shieldStrength=100;
        this.running=false;
        this.arrested = false;


    }
    public void attackAnotherCharacter(Character otherChar){
        if(this.attackPower>1){
            otherChar.strength--;
        }

    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
}
