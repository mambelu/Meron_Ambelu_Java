package com.company;

public class Farmer extends Character{
private boolean plowing;
private boolean harvesting;

    public Farmer(){
        this.strength=75;
        this.health=100;
        this.stamina=75;
        this.speed=10;
        this.attackPower=1;
        this.running=false;
        this.arrested=false;
        this.plowing=false;
        this.harvesting=false;
    }
    public void attackAnotherCharacter(Character otherChar){

        if(this.attackPower>0) {
            otherChar.strength--;
            otherChar.health--;
            this.attackPower--;
        }else {
            System.out.println( this.name + "has no enough power to attack");
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
