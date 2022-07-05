package com.company.pointofsale;

import java.util.*;

public class IceCream {
    private String flavor;
    private double price;
    private int quantity;
    private int quantitySold;
    private double tax = 0.23;

//********************************//***********************************
    public double calculatetotalPrice(List<IceCream> iceCreamList){
        double totalPrice = 0.0;
        for(int i=0; i<iceCreamList.size(); i++) {

            totalPrice += (iceCreamList.get(i).getPrice()* iceCreamList.get(i).getQuantity())+((iceCreamList.get(i).getPrice()* iceCreamList.get(i).getQuantity())*tax);

        }
        return totalPrice;
    }

    //*****************************//**********************************
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

    //***********************************//***************************


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

    public static void main(String[] args) {
        IceCream icecream = new IceCream();
        icecream.setPrice(2.0);
        icecream.setQuantity(2);
        icecream.setFlavor("Vanilla");


        IceCream icecream1 = new IceCream();
        icecream1.setPrice(2.0);
        icecream1.setPrice(2);
        icecream1.setFlavor("chocolate");

        List<IceCream> list1 = new ArrayList<>();
        list1.add(icecream);
        list1.add(icecream1);


        System.out.println(icecream.calculatetotalPrice(list1));






    }


}
