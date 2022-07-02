package com.company;

public class Farmer extends Character{
private boolean plowing;
private boolean harvesting;

    public Farmer(boolean plowing, boolean harvesting,
                  String name,int strength,int health,int stamina,int speed,int attackPower,
                  boolean running,boolean arrested)
    {
        super(name,strength,health,stamina,speed,attackPower,running,arrested);
        this.plowing = plowing;
        this.harvesting = harvesting;

        this.plowing = false;
        this.harvesting = false;

    }
    public void attackAnotherCharacter(Character otherChar){

            otherChar.strength--;


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

    @Override
    public String toString() {
        return "Farmer{" +
                "plowing=" + plowing +
                ", harvesting=" + harvesting +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                ", health=" + health +
                ", stamina=" + stamina +
                ", speed=" + speed +
                ", attackPower=" + attackPower +
                ", running=" + running +
                ", arrested=" + arrested +
                '}';
    }
}
