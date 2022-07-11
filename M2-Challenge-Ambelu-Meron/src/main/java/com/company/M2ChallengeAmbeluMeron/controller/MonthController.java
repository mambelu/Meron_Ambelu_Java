package com.company.M2ChallengeAmbeluMeron.controller;

import com.company.M2ChallengeAmbeluMeron.exceptions.NotFoundException;
import com.company.M2ChallengeAmbeluMeron.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthController {

    private static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month("January", 1),
            new Month("February", 2),
            new Month("March", 3),
            new Month("April", 4),
            new Month("May", 5),
            new Month("June", 6),
            new Month("July", 7),
            new Month("August", 8),
            new Month("September", 9),
            new Month("October", 10),
            new Month("November", 11),
            new Month("December", 12)));




    @RequestMapping(value="/month/{monthNumber}", method= RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonth(@PathVariable int monthNumber) {
        Month returnMonth = null;
        if(monthNumber<1||monthNumber>12){
            throw new IllegalArgumentException("Month number must be between 1 and 12");
        }else{

        for (Month month : monthList) {
            if (month.getNumber() == monthNumber) {
                returnMonth = month;
                break;
            }
        }
    }

        return returnMonth;
    }


    @RequestMapping(value="/randomMonth", method= RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public Month getRandomMonth(){
        Random monthNumber = new Random();
        int randomID = monthNumber.nextInt(13) + 1;

       for(Month month : monthList){
           if(month.getNumber()==randomID){
               return month;
           }
        }
       return null;
    }

}
