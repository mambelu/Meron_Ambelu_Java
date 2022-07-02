package com.company;


public  abstract class Character {
    protected String name;
    protected int strength;
    protected int health;
    protected int stamina;
    protected int speed;
    protected int attackPower;

    protected boolean running;
    protected boolean arrested;
    public abstract void attackAnotherCharacter(Character otherChar);


    protected Character(String name, int strength,int health, int stamina, int speed,
                        int attackPower,
                        boolean running, boolean arrested) {
        this.name = name;
        this.strength = strength;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;

        this.running = running;
        this.arrested = arrested;
        this.health = health;
    }


}
