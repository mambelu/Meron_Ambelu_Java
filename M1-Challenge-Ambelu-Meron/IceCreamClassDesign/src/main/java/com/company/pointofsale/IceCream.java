package com.company.pointofsale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IceCream {
    private String flavor;
    private double price;
    private int quantity;


    /* method takes a list of icecreams and reaturns the flavour : quantity pair*/
    public void quantityOfEachIceCream(List<IceCream> icecreamList){
        Map<String, Integer> icecreamMap = new HashMap<>();
        for(int i = 0; i<icecreamList.size(); i++){
            icecreamMap.put(icecreamList.get(i).getFlavor(),icecreamList.get(i).getQuantity());
        }
        Set<Map.Entry<String, Integer>> icecreamEntries = icecreamMap.entrySet();
        for(Map.Entry<String, Integer> flavorQuantitypair : icecreamEntries){
            System.out.println("Flavour: "+ flavorQuantitypair.getKey()+" Quantity: "+ flavorQuantitypair.getValue());
        }


    }

    // method which calculates the total  price of ice cream list considering the price for all type of flavors is the same and no tax
    public double calculatetotalPrice(List<IceCream> iceCreamList){
        double totalPrice = 0.0;
        for(int i=0; i<iceCreamList.size(); i++) {

            totalPrice =totalPrice+ iceCreamList.get(i).getPrice()* iceCreamList.get(i).getQuantity();

        }
        return totalPrice;
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


}
