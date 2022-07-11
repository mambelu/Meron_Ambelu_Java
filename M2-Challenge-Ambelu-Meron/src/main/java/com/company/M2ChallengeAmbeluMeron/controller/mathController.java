package com.company.M2ChallengeAmbeluMeron.controller;

import com.company.M2ChallengeAmbeluMeron.model.MathSolution;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mathController {

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public MathSolution addTwoOperands(@RequestBody MathSolution operands){
        MathSolution returnVal = new MathSolution();
        returnVal.setOperand1(operands.getOperand1());
        returnVal.setOperand2(operands.getOperand2());
        returnVal.setOperation("add");


            returnVal.setAnswer(Integer.parseInt(operands.getOperand1()) + Integer.parseInt(operands.getOperand2()));
            return returnVal;
    }



    @RequestMapping(value = "/subtract", method= RequestMethod.POST)
    public MathSolution subtractTwoOperands(@RequestBody MathSolution operands){
        MathSolution returnVal = new MathSolution();
        returnVal.setOperand1(operands.getOperand1());
        returnVal.setOperand2(operands.getOperand2());
        returnVal.setOperation("subtract");
        returnVal.setAnswer(Integer.parseInt(operands.getOperand1()) - Integer.parseInt(operands.getOperand2()));
        return returnVal;

    }

    @RequestMapping(value = "/multiply", method= RequestMethod.POST)
    public MathSolution multiplyTwoOperands(@RequestBody MathSolution operands){
        MathSolution returnVal = new MathSolution();
        returnVal.setOperand1(operands.getOperand1());
        returnVal.setOperand2(operands.getOperand2());
        returnVal.setOperation("multiply");
        returnVal.setAnswer(Integer.parseInt(operands.getOperand1()) * Integer.parseInt(operands.getOperand2()));
        return returnVal;

    }


    @RequestMapping(value = "/divide", method= RequestMethod.POST)
    public MathSolution divideTwoOperands(@RequestBody MathSolution operands){
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
