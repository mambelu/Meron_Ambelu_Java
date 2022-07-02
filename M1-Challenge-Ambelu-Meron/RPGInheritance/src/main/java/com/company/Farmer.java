package com.company;

public class Farmer extends Character{
private boolean plowing;
private boolean harvesting;

    public Farmer(boolean plowing, boolean harvesting,
                  String name,int strength,int health,int stamina,int speed,int attackPower,
                  int shieldStrength,boolean running,boolean arrested)
    {
        super(name,strength,health,stamina,speed,attackPower,running,arrested);
        this.plowing = plowing;
        this.harvesting = harvesting;
        this.strength=75;
        this.health=100;
        this.stamina=75;
        this.speed=10;
        this.attackPower=1;
        this.running=false;
        this.arrested = false;
        this.plowing = false;
        this.harvesting = false;

    }
    public void attackAnotherCharacter(Character otherChar){
        if(this.attackPower>1){
            otherChar.strength--;
        }

    }

    public boolean isPlowing() {
        return plowing;
    }

    public void setPlowing(boolean plowing) {
        this.plowing = plowing;
    }

    public boolean isHarvesting() {
        return harvesting;
    }

    public void setHarvesting(boolean harvesting) {
        this.harvesting = harvesting;
    }
}
