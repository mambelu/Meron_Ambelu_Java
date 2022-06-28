package com.company;

public class ConverterApplication {
    public static void main(String[] args) {
        //ConverterIf instance
        Converter converter = new ConverterIf();

        System.out.println(converter.convertMonth(11));

        System.out.println(converter.convertDay(5));

        //converterSwitch instance
        Converter converter1 = new ConverterSwitch();

        System.out.println(converter1.convertMonth(11));

        System.out.println(converter1.convertDay(5));


    }
}
