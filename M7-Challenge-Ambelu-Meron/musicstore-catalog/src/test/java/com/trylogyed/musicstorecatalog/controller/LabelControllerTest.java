package com.trylogyed.musicstorecatalog.controller;

import static org.junit.Assert.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trylogyed.musicstorecatalog.model.Label;
import com.trylogyed.musicstorecatalog.repository.LabelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LabelController.class)
public class LabelControllerTest {


    @MockBean
    LabelRepository labelRepository;
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    private Label label;
    private String labelJson;
    private List<Label> allLabels = new ArrayList<>();
    private String allLabelsJson;

    @Before
    public void setup() throws Exception {
        setUpLabelMock();
    }

    public void setUpLabelMock() {
        label = new Label("meron","meron@hello.com");

        Label labelWithId = new Label(1,"name1", "www.me.com");


        Label label1 = new Label(2,"another name","www.meagain.com");
        allLabels.add(labelWithId);
        allLabels.add(label1);

        doReturn(allLabels).when(labelRepository).findAll();
        doReturn(labelWithId).when(labelRepository).save(label);

    }

    @Test
    public void shouldReturnAllLabels() throws Exception{

        doReturn(allLabels).when(labelRepository).findAll();

        String expectedJsonValue = mapper.writeValueAsString(allLabels);

        mockMvc.perform(get("/labels"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJsonValue));
    }


    @Test
    public void ShouldFindLabelByIdAndReturnStatus200() throws Exception {
        Label  labelTest =new Label(1,"Name1","meron@hello.com");

        Optional<Label> optionalLabel = Optional.of(labelTest);
        when(labelRepository.findById(1)).thenReturn(optionalLabel);

        if (optionalLabel.isPresent()){
            labelTest = optionalLabel.get();
        }

        String expectedJson = mapper.writeValueAsString(labelTest);

        mockMvc.perform(get("/labels/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));

    }

    @Test
    public void shouldReturnAllLabelsAndStatus200() throws Exception {
        List<Label> labelList = new ArrayList<>();

        Label  labelTest1 =new Label(1,"Name1","meron@hello.com");
        Label  labelTest2 =new Label(2,"Name2","meron222@hello.com");
        labelList.add(labelTest1);
        labelList.add(labelTest2);

        doReturn(labelList).when(labelRepository).findAll();

        String expectedJsonValue = mapper.writeValueAsString(labelList);

        mockMvc.perform(get("/labels"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJsonValue));

    }

    @Test
    public void shouldCreateLabel() throws Exception {

        Label  input =new Label("Name1","meron@hello.com");
        Label  output =new Label(1,"Name1","meron@hello.com");



        String outputJson = mapper.writeValueAsString(output);
        String inputJson = mapper.writeValueAsString(input);

        // doReturn(expectedTrack).when(labelRepository).save(actualLabel);
        when(labelRepository.save(input)).thenReturn(output);

        mockMvc.perform(post("/labels")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(outputJson));

    }

    @Test
    public void shouldUpdateLabelAndReturnStatus204() throws Exception {

        Label  input =new Label(1,"Name1","meron@hello.com");
        Label  output =new Label(1,"new name","meron@hello.com");

        String outputJson = mapper.writeValueAsString(output);
        String inputJson = mapper.writeValueAsString(input);

        when(labelRepository.save(input)).thenReturn(output);

        mockMvc.perform(
                        put("/label")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void ShouldFindAndDeleteLabelAndReturnStatus204() throws Exception {

        Label  input =new Label(1,"Name1","meron@hello.com");

        Optional<Label> optionalInput = Optional.of(input);
        when(labelRepository.findById(10)).thenReturn(optionalInput);

        labelRepository.delete(input);
        //verify that label repo invokes the method .delete. number of times we tell the method 1 in this case
        Mockito.verify(labelRepository, times(1)).delete(input);

        String expectedJsonValue = mapper.writeValueAsString(input);

        mockMvc.perform(delete("/label/10")) //Act
                .andDo(print())
                .andExpect(status().isNoContent());
    }



}