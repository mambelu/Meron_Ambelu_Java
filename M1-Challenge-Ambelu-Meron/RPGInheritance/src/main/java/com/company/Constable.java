package com.company;

public class Constable extends Character{
private int jurisdiction;

    public Constable(int jurisdiction,String name,int strength,int health,int stamina,
                     int speed,int attackPower, int shieldStrength,boolean running,boolean arrested)
    {
        super(name,strength,health,stamina,speed,attackPower,running,arrested);
        this.jurisdiction = jurisdiction;
        this.strength=60;
        this.health=100;
        this.stamina=60;
        this.speed=20;
        this.attackPower=5;
        this.running=false;
        this.arrested = false;


    }

    public void attackAnotherCharacter(Character otherChar){
        if(this.attackPower>1){
        otherChar.strength--;
        } 

    }
    public void arrestAnotherCharacter(Character otherChar){
        this.jurisdiction++;

}

    public int getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
