package com.company;

public class ConverterApplication {
    public static void main(String[] args) {
        //ConverterIf instance

        System.out.println("Using the ConverterIf class");
        Converter converter = new ConverterIf();

        System.out.println("Corresponding month for number 11 is "+ converter.convertMonth(11));

        System.out.println("Corresponding day for number 5 is "+converter.convertDay(5));

        //converterSwitch instance

        System.out.println();

        System.out.println("Using the ConverterSwitch class");


        Converter converter1 = new ConverterSwitch();

        System.out.println("Corresponding month for number  11 is "+converter1.convertMonth(11));

        System.out.println("Corresponding day for number 5 is "+converter1.convertDay( 5));


    }
}
