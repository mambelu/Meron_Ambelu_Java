package com.company.M2ChallengeAmbeluMeron.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathSolution {

    private String operand1;
    private String operand2;
    private String operation;
    private int answer;

    public MathSolution(){

}
    public MathSolution(String operand1, String operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public MathSolution(String operand1, String operand2, String operation, int answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }

    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
