package com.company.pointofsale;

import java.util.List;

public class IceCream {
    private String flavor;
    private double price;
    private int quantity;
    private double taxRate = 0.23;

    public IceCream(String flavor, double price, int quantity) {
        this.flavor = flavor;
        this.price = price;
        this.quantity = quantity;

    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void closeStore(){
        if(this.getQuantity()==0){
            System.out.println("We have no more icecreams to sale close the store");
        }
    }

    // method which calculates the subtotal  price of ice cream. considering the price for all type of flavors is the same
    public double calculateSubTotal(){
        double subTotal = (this.getPrice()*this.getQuantity())/(1+taxRate);
        return subTotal;

    }
}
