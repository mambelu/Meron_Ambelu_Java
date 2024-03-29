package com.company.M2ChallengeAmbeluMeron.controller;

import com.company.M2ChallengeAmbeluMeron.model.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {
    @Autowired
    private MockMvc mocMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnMonthByMonthNumber() throws Exception{
        //Arrange
        Month expectedMonth = new Month("February", 2);
        String expectedJson = mapper.writeValueAsString(expectedMonth);
        mocMvc.perform(get("/month/2")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
    @Test
    public void shouldReturn422StatusCodeForOutOfRangeRequest() throws Exception{

        //Arrange
        //Act
        mocMvc.perform(
                get("/month/13"))
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());


    }

    //Random month end point mock mvc test

    @Test
    public void shouldReturnNonEmptyValue() throws Exception {
        mocMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty()
                );
    }

    @Test
    public void shouldReturnAValueFromMonthList() throws Exception {
        mocMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty());
    }

}