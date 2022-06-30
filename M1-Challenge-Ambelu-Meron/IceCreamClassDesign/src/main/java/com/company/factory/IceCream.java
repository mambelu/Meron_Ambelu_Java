package com.company.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IceCream {
    private String flavor;
    private double salePrice;
    private int productionCost;
    private String productionTime;
    private List<String> ingredients = new ArrayList<>();



    //restockIcecream will return true if the qiantity of icecream that was passed as an arguement is zero;
  public boolean restockIcecream(com.company.pointofsale.IceCream iceCream){
      boolean returnVal =false;
      if(iceCream.getQuantity()==0){
          returnVal = true;

      }
    return returnVal;
  }



    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(int productionCost) {
        this.productionCost = productionCost;
    }

    public String getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(String productionTime) {
        this.productionTime = productionTime;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
