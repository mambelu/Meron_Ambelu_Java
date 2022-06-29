package com.company;

public class Constable extends Character{
    private String jurisdiction;
    private boolean arrestAnotherCharacter;
    private int strength = 60;
    private int health = 100;
    private int stamina =60;
    private int speed = 20;
    private int attackPower = 5;
    private boolean running = false;

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public boolean isArrestAnotherCharacter() {
        return arrestAnotherCharacter;
    }

    public void setArrestAnotherCharacter(boolean arrestAnotherCharacter) {
        this.arrestAnotherCharacter = arrestAnotherCharacter;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isArrested() {
        return arrested;
    }

    public void setArrested(boolean arrested) {
        this.arrested = arrested;
    }

    private boolean arrested = false;


}
