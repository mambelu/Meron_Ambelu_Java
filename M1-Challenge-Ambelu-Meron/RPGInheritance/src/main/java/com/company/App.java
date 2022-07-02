package com.company;

public class App {
    public static void main(String[] args) {
        Farmer meron = new Farmer(true,true,"meron",76, 65,56,99,9,false,false);
        System.out.println(meron);

        Warrior nardi = new Warrior(54,"nardi",45,100,45,78,5,false,false);

        nardi.attackAnotherCharacter(meron);

        System.out.println(meron);
    }
}
