package com.company;

public class App {
    public static void main(String[] args) {
        Character meron = new Farmer();
        System.out.println(meron.getStrength());

        Warrior nardi = new Warrior();

        nardi.attackAnotherCharacter(meron);

        System.out.println(meron.getStrength());
    }
}
