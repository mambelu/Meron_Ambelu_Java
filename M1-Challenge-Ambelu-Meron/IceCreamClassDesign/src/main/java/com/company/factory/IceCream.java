package com.company.factory;

import java.util.ArrayList;
import java.util.List;


public class IceCream {
    private String flavor;
    private double salePrice;
    private double productionCost;
    private String productionTime;

    private List<String> ingredients = new ArrayList<>();

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }


//********************************************//*************************************
    public boolean restockIcecream(com.company.pointofsale.IceCream iceCream){
      boolean returnVal =false;
      if(iceCream.getQuantity()==0){
          returnVal = true;

      }
    return returnVal;
  }



  //*****************************************//*********************************************
  public double calculateProfit(){
      double profit = this.salePrice- this.productionCost;
      return profit;

  }


  //********************************************//*************************************
  public boolean isallergyCaution(){
        boolean returnVal = false;
        for( int i = 0 ; i< ingredients.size(); i++){
            if (ingredients.get(i)=="peanut"){
                returnVal = true;

            }
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

    public double getProductionCost() {
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
