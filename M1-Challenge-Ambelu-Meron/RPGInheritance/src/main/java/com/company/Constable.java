package com.company;

public class Constable extends Character{
private boolean jurisdiction;

    public Constable(){
        this.strength=60;
        this.health=100;
        this.stamina=60;
        this.speed=20;
        this.attackPower=5;
        this.running=false;
        this.arrested=false;

    }

    public boolean getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(boolean jurisdiction) {
        this.jurisdiction = jurisdiction;
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
    public void arrestAnotherCharacter(Character otherChar){

    if((this.jurisdiction == true)&&( otherChar.running ==true)){
     System.out.println(this.getName() + " can arrest "+ otherChar.getName());
 }


}

    @Override
    public String toString() {
        return "Constable{" +
                "jurisdiction=" + jurisdiction +
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
