package com.company;

public class ConverterIf implements Converter {
    public String convertMonth(int monthNumber) {
        String month ="month";
        if (monthNumber >= 1 && monthNumber <= 12) {
            if (monthNumber == 1) {
                month="January";
            } else if (monthNumber == 2) {
                month="February";
            } else if (monthNumber == 3) {
                month="March";


            } else if (monthNumber == 4) {
                month="April";
            } else if (monthNumber == 5) {
                month="May";
            } else if (monthNumber == 6) {
                month="June";
            } else if (monthNumber == 7) {
                month="July";
            } else if (monthNumber == 8) {
                month="August";
            } else if (monthNumber == 9) {
                month="September";
            } else if (monthNumber == 10) {
                month="October";
            } else if (monthNumber == 11) {
                month="November";
            } else if (monthNumber == 12) {
                month="December";
            }
        } else {
            System.out.println( "Error, the value  is not from 1 to 12");
        }
        return month;
    }

    public String convertDay(int dayNumber) {
        String day="day";
        if (dayNumber >= 1 && dayNumber <= 7) {
            if (dayNumber == 1) {
                day= "Sunday";
            } else if (dayNumber == 2) {
                day=  "Monday";
            } else if (dayNumber == 3) {
                day=  "Tuesday";

            } else if (dayNumber == 4) {
                day=  "Wednesday";
            } else if (dayNumber == 5) {
                day=  "Thursday";
            } else if (dayNumber == 6) {
                day= "Friday";
            } else if (dayNumber == 7) {
                day=  "Saturday";
            }


        } else {

            System.out.println("Error, the value is not between 1 and 12");
        }
        return day;

    }
}

