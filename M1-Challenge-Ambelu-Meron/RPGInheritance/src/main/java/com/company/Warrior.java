package com.company;

public class Warrior extends Character{
    private int shieldStrength;

    public Warrior(){
        this.strength=75;
        this.health=100;
        this.stamina=100;
        this.speed=50;
        this.attackPower=10;
        this.shieldStrength=100;
        this.running=false;
        this.arrested=false;



    }
    public void attackAnotherCharacter(Character otherChar){
        otherChar.strength--;


    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "shieldStrength=" + shieldStrength +
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
