package com.company.M2ChallengeAmbeluMeron.model;

public class Month {
    private String name;
    private int number;

    public Month(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Month(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
