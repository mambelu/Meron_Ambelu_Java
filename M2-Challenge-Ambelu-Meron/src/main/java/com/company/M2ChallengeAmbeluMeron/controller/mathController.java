package com.company.M2ChallengeAmbeluMeron.controller;

import com.company.M2ChallengeAmbeluMeron.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class mathController {

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution addTwoOperands(@RequestBody @Valid  MathSolution operands){
        MathSolution returnVal = new MathSolution();
        returnVal.setOperand1(operands.getOperand1());
        returnVal.setOperand2(operands.getOperand2());
        returnVal.setOperation("add");


            returnVal.setAnswer(Integer.parseInt(operands.getOperand1()) + Integer.parseInt(operands.getOperand2()));
            return returnVal;
    }



    @RequestMapping(value = "/subtract", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution subtractTwoOperands(@RequestBody @Valid MathSolution operands){
        MathSolution returnVal = new MathSolution();
        returnVal.setOperand1(operands.getOperand1());
        returnVal.setOperand2(operands.getOperand2());
        returnVal.setOperation("subtract");
        returnVal.setAnswer(Integer.parseInt(operands.getOperand1()) - Integer.parseInt(operands.getOperand2()));
        return returnVal;

    }

    @RequestMapping(value = "/multiply", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution multiplyTwoOperands(@RequestBody @Valid MathSolution operands){
        MathSolution returnVal = new MathSolution();
        returnVal.setOperand1(operands.getOperand1());
        returnVal.setOperand2(operands.getOperand2());
        returnVal.setOperation("multiply");
        returnVal.setAnswer(Integer.parseInt(operands.getOperand1()) * Integer.parseInt(operands.getOperand2()));
        return returnVal;

    }


    @RequestMapping(value = "/divide", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution divideTwoOperands(@RequestBody @Valid MathSolution operands){
        MathSolution returnVal = new MathSolution();
        returnVal.setOperand1(operands.getOperand1());
        returnVal.setOperand2(operands.getOperand2());
        returnVal.setOperation("divide");
        if(Integer.parseInt(operands.getOperand2())!=0) {
            returnVal.setAnswer(Integer.parseInt(operands.getOperand1()) / Integer.parseInt(operands.getOperand2()));
            return returnVal;
        }else if(Integer.parseInt(operands.getOperand2())==0){
            throw new IllegalArgumentException("Number can not divide by zero");
        }else
       return null;

    }


}
