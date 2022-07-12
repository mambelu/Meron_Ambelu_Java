package com.company.M2ChallengeAmbeluMeron.controller;

import com.company.M2ChallengeAmbeluMeron.model.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(mathController.class)
public class mathControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }



    @Test
    public void shouldReturnSumOfTwoOperands() throws Exception {


        // ARRANGE
        MathSolution inputBody = new MathSolution("10","7");


        String inputJson = mapper.writeValueAsString(inputBody);

        MathSolution outputBody = new MathSolution();
        outputBody.setOperand1("10");
        outputBody.setOperand2("7");
        outputBody.setOperation("add");
        outputBody.setAnswer(17);

        String outputJson = mapper.writeValueAsString(outputBody);

        // ACT
        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidOperandsToAdd() throws Exception {
        // ARRANGE
        MathSolution inputBody = new MathSolution();
        inputBody.setOperand1("invalid string");
        inputBody.setOperand2("7");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        // ACT
        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


    @Test
    public void shouldReturn422ErrorIfEmptyStringIsPassedToAnyOfTheOperandsToAdd() throws Exception {
        // ARRANGE
        MathSolution inputBody = new MathSolution("2", "");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        // ACT
        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }



    // MockMVC test for successful response the "/subtract" end point
    @Test
    public void shouldReturnDifferenceOfTwoOperands() throws Exception {

        // ARRANGE
        // ARRANGE
        MathSolution inputBody = new MathSolution("10","7");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        MathSolution outPutBody = new MathSolution();
        outPutBody.setOperand1("10");
        outPutBody.setOperand2("7");
        outPutBody.setOperation("subtract");
        outPutBody.setAnswer(3);

        String outputJson = mapper.writeValueAsString(outPutBody);

        // ACT
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidOperandsToSubtract() throws Exception {
        // ARRANGE
        MathSolution inputBody = new MathSolution();
        inputBody.setOperand1("invalid string");
        inputBody.setOperand2("7");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        // ACT
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422ErrorIfEmptyStringIsPassedToAnyOfTheOperandsToSubtract() throws Exception {
        // ARRANGE
        MathSolution inputBody = new MathSolution("2", "");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        // ACT
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }


    @Test
    public void shouldReturnProductOfTwoOperands() throws Exception {

        // ARRANGE
        // ARRANGE
        MathSolution inputBody = new MathSolution("10","7");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        MathSolution outPutBody = new MathSolution();
        outPutBody.setOperand1("10");
        outPutBody.setOperand2("7");
        outPutBody.setOperation("multiply");
        outPutBody.setAnswer(70);

        String outputJson = mapper.writeValueAsString(outPutBody);

        // ACT
        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidOperandsToMultiply() throws Exception {
        // ARRANGE
        MathSolution inputBody = new MathSolution();
        inputBody.setOperand1("invalid string");
        inputBody.setOperand2("7");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        // ACT
        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422ErrorIfEmptyStringIsPassedToAnyOfTheOperandsToMultiply() throws Exception {
        // ARRANGE
        MathSolution inputBody = new MathSolution("2", "");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        // ACT
        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }


    @Test
    public void shouldReturnQuotientOfTwoOperands() throws Exception {

        // ARRANGE
        // ARRANGE
        MathSolution inputBody = new MathSolution("10","2");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        MathSolution outPutBody = new MathSolution();
        outPutBody.setOperand1("10");
        outPutBody.setOperand2("2");
        outPutBody.setOperation("divide");
        outPutBody.setAnswer(5);

        String outputJson = mapper.writeValueAsString(outPutBody);

        // ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidOperandsToDivide() throws Exception {
        // ARRANGE
        MathSolution inputBody = new MathSolution();
        inputBody.setOperand1("invalid string");
        inputBody.setOperand2("7");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        // ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422ErrorIfOperand2IsZero() throws Exception {
        // ARRANGE
        MathSolution inputBody = new MathSolution("2", "0");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        // ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }


    @Test
    public void shouldReturn422ErrorIfEmptyStringIsPassedToAnyOfTheOperandsToDivide() throws Exception {
        // ARRANGE
        MathSolution inputBody = new MathSolution("2", "");

        // Convert Java Object to JSON.
        String inputJson = mapper.writeValueAsString(inputBody);

        // ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }






}