package com.company.pointofsale;

import java.util.*;

public class IceCream {
    private String flavor;
    private double price;
    private int quantity;
    private int quantitySold;
    private double tax = 0.23;

    private String topping;


    private int noOfScoop;

//**********************Calculates total price***********************************
    public double calculatetotalPrice(List<IceCream> iceCreamList){
        double totalPrice = 0.0;
        for(int i=0; i<iceCreamList.size(); i++) {

            totalPrice += (iceCreamList.get(i).getPrice()* iceCreamList.get(i).getQuantity()*iceCreamList.get(i).getNoOfScoop())+((iceCreamList.get(i).getPrice()* iceCreamList.get(i).getQuantity()*iceCreamList.get(i).getNoOfScoop())*tax);

        }
        return totalPrice;
    }

    //**********************Compares the quantity sold property of List of ice cream and gets the high demand flavor*********************************
    public void highDemandFlavor(List<IceCream> mylist){

        double max = 0;
        mylist = new ArrayList<>();

        for( int i =0; i< mylist.size(); i++){
            if  (mylist.get(i).getQuantitySold()> max){
                max=mylist.get(i).getQuantitySold();

                System.out.println(mylist.get(i).getFlavor() + " is high demand icecream.");
            }
        }
    }


    //*****************************The addTopping method will add 1 to the price **//***************************
    public void addTopping(){
       this.price+=1;
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

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
    public int getNoOfScoop() {
        return noOfScoop;
    }

    public void setNoOfScoop(int noOfScoop) {
        this.noOfScoop = noOfScoop;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
}
