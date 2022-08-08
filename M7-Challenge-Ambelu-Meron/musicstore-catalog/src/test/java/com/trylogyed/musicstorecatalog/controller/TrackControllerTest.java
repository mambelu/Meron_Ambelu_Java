package com.trylogyed.musicstorecatalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trylogyed.musicstorecatalog.model.Track;
import com.trylogyed.musicstorecatalog.repository.TrackRepository;
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
@WebMvcTest(TrackController.class)

public class TrackControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TrackRepository trackRepo;

    ObjectMapper mapper = new ObjectMapper();


    @Test
    public void shouldReturnAllTracks() throws Exception{

        List<Track> trackList = new ArrayList<>(Arrays.asList(new Track(1,1, "title1", 200),new Track(2,2, "title2", 250)));
        Mockito.when(trackRepo.findAll()).thenReturn(trackList);
        String expectedJson = mapper.writeValueAsString(trackList);

        mockMvc.perform(get("/tracks"))//Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));

    }


    @Test
    public void ShouldFindTrackByIdAndReturnStatus200() throws Exception {
        Track track1 = new Track();
        track1.setId(1);
        track1.setTitle("one love");
        track1.setAlbumId(1);
        track1.setRuntime(100);

        Optional<Track> thisTrack = Optional.of(track1);
        when(trackRepo.findById(1)).thenReturn(thisTrack);

        if (thisTrack.isPresent()){
            track1 = thisTrack.get();
        }

        String expectedJsonValue = mapper.writeValueAsString(track1);

        mockMvc.perform(get("/tracks/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJsonValue));

    }

    @Test
    public void shouldCreateTrackAndReturnNewTrackAndStatus200() throws Exception {
        Track inputTrack = new Track();
        inputTrack.setTitle("Awesome Song");
        inputTrack.setAlbumId(1);
        inputTrack.setRuntime(100);

        Track outputTrack = new Track();
        outputTrack.setId(1);
        outputTrack.setTitle("Awesome Song");
        outputTrack.setAlbumId(1);
        outputTrack.setRuntime(100);

        String outputJson = mapper.writeValueAsString(outputTrack);
        String inputJson = mapper.writeValueAsString(inputTrack);

        // doReturn(outputTrack).when(trackRepository).save(inputTrack);
        when(trackRepo.save(inputTrack)).thenReturn(outputTrack);

        mockMvc.perform(post("/tracks")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(outputJson));

    }

    @Test
    public void shouldUpdateTrackAndReturnStatus204() throws Exception {

        Track inputTrack = new Track( 1,1, "one love", 100);
        Track outputTrack = new Track(1, 1, "updated love", 100);


        String outputJson = mapper.writeValueAsString(outputTrack);
        String inputJson = mapper.writeValueAsString(inputTrack);

        when(trackRepo.save(inputTrack)).thenReturn(outputTrack);

        mockMvc.perform(
                        put("/track")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());

    }

    @Test
    public void ShouldFindAndDeleteTrackAndReturnStatus204() throws Exception {
        Track track1 = new Track(1, 1, "one love", 100);

        Optional<Track> optionalTrack = Optional.of(track1);
        Mockito.when(trackRepo.findById(1)).thenReturn(optionalTrack);

        if (optionalTrack.isPresent()){
            track1 = optionalTrack.get();
        }

        mockMvc.perform(delete("/track/1")) //Act
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}