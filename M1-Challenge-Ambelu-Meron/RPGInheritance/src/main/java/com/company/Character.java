package com.company;

public class Character {
    private String name;

    private String abilities;

    private boolean attackAnotherCharacter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public boolean isAttackAnotherCharacter() {
        return attackAnotherCharacter;
    }

    public void setAttackAnotherCharacter(boolean attackAnotherCharacter) {
        this.attackAnotherCharacter = attackAnotherCharacter;
    }
}
