package com.company;

public class Calculator {
    //a set of methods to add, subtract , multiply and divide two doubles
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {

        int returnval = 0;

        if(b != 0) {
            returnval = a / b;
        }
        else{
            System.out.println(" a number can not be divided by zero");
        }

        return returnval;
    }

    //Below is a set of methods for add, subtract , multiply and divide two doubles

    public double add(double a, double b) {
        return a + b;
    }


    public double subtract(double a, double b) {
        return a - b;
    }


    public double multiply(double a, double b) {
        return a * b;
    }



    public double divide(double a, double b) {


        double returnval = 0.0;

        if(b != 0) {
            returnval = a / b;
        }
        else{
            System.out.println(" a number can not be divided by zero");
        }

        return returnval;
    }


//main method to create the calculator object

    public static void main(String[] args) {
        Calculator calcObject = new Calculator();

        System.out.print(2+"+"+2+"=");

        System.out.println(calcObject.add(2,2));

        System.out.print(1+"+"+1+"=");

        System.out.println(calcObject.add(1,1));

        System.out.print(23+"-"+52+"=");

        System.out.println(calcObject.subtract(23,52));

        System.out.print(34+"*"+2+"=");

        System.out.println( calcObject.multiply(34,2));

        System.out.print(12+"/"+3+"=");

        System.out.println( calcObject.divide(12,3));

        System.out.print(12.0+"/"+7.0+"=");

        System.out.println( calcObject.divide(12.0,7.0));

        System.out.print(3.4+"+"+2.3+"=");

        System.out.println(calcObject.add(3.4,2.3));

        System.out.print(6.7+"*"+4.4+"=");

        System.out.println( calcObject.multiply(6.7,4.4));

        System.out.print(5.5+"-"+0.5+"=");

        System.out.println(calcObject.subtract(5.5,0.5));

        System.out.print(10.8+"/"+2.2+"=");

        System.out.print(calcObject.divide(10.8,2.2));







    }



}
