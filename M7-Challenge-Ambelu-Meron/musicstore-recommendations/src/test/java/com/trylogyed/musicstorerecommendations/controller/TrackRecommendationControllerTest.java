package com.trylogyed.musicstorerecommendations.controller;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trylogyed.musicstorerecommendations.model.TrackRecommendation;

import com.trylogyed.musicstorerecommendations.repsitory.TrackRecommendationRepo;
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
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TrackRecommendationController.class)

public class TrackRecommendationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TrackRecommendationRepo trackRepository;

    ObjectMapper mapper = new ObjectMapper();

    private TrackRecommendation track;
    private List<TrackRecommendation> allTracks = new ArrayList<>();
    private String trackJson;
    private String allTracksJson;

    @Before
    public void setup() throws Exception {
        setupTrackControllerMock();
    }
    private void setupTrackControllerMock(){
        TrackRecommendation track = new TrackRecommendation();
        track.setTrackRecommendationId(1);
        track.setTrackId(1);
        track.setUserId(1);
        track.setLiked(true);

        TrackRecommendation trackWithId = new TrackRecommendation();
        trackWithId.setTrackRecommendationId(1);
        trackWithId.setTrackId(1);
        trackWithId.setUserId(1);
        trackWithId.setLiked(true);

        TrackRecommendation track2 = new TrackRecommendation();
        track2.setTrackId(2);
        track2.setTrackId(2);
        track2.setUserId(2);
        track2.setLiked(false);

        allTracks.add(trackWithId);
        allTracks.add(track2);

        doReturn(allTracks).when(trackRepository).findAll();
        doReturn(trackWithId).when(trackRepository).save(track);

    }


    @Test
    public void shouldReturnAllTrackRecommendation() throws Exception{

        List<TrackRecommendation> trackList = new ArrayList<TrackRecommendation>();
        trackList.add(new TrackRecommendation(1,1, 1, true));
        trackList.add(new TrackRecommendation(2,2, 2, false));
        Mockito.when(trackRepository.findAll()).thenReturn(trackList);
        String expectedJson = mapper.writeValueAsString(trackList);

        mockMvc.perform(get("/trackRecommendations"))//Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));

    }


    @Test
    public void shouldCreateTrackAndReturnNewTrackAndStatus200() throws Exception {
        TrackRecommendation inputTrack = new TrackRecommendation();
        inputTrack.setTrackId(1);
        inputTrack.setUserId(1);
        inputTrack.setLiked(true);

        TrackRecommendation outputTrack = new TrackRecommendation();
        outputTrack.setTrackRecommendationId(1);
        outputTrack.setUserId(1);
        outputTrack.setTrackId(1);
        outputTrack.setLiked(true);

        String outputTrackJson = mapper.writeValueAsString(outputTrack);
        String inputTrackJson = mapper.writeValueAsString(inputTrack);

        when(trackRepository.save(inputTrack)).thenReturn(outputTrack);

        mockMvc.perform(post("/trackRecommendations")
                        .content(inputTrackJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(outputTrackJson));

    }

    @Test
    public void shouldUpdateTrackAndReturnStatus204() throws Exception {

        TrackRecommendation inputTrack = new TrackRecommendation();
        inputTrack.setTrackRecommendationId(1);
        inputTrack.setTrackId(1);
        inputTrack.setUserId(1);
        inputTrack.setLiked(true);

        TrackRecommendation outputTrack = new TrackRecommendation();
        outputTrack.setTrackRecommendationId(1);
        outputTrack.setTrackId(1);
        outputTrack.setUserId(1);
        outputTrack.setLiked(false);

        String outputJson = mapper.writeValueAsString(outputTrack);
        String inputJson = mapper.writeValueAsString(inputTrack);

        when(trackRepository.save(inputTrack)).thenReturn(outputTrack);

        mockMvc.perform(
                        put("/trackRecommendations")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void ShouldDeleteAlbumById() throws Exception {
        TrackRecommendation track1 = new TrackRecommendation(1, 1, 1, false);

        Optional<TrackRecommendation> optionalTrack = Optional.of(track1);
        Mockito.when(trackRepository.findById(1)).thenReturn(optionalTrack);

        if (optionalTrack.isPresent()){
            track1 = optionalTrack.get();
        }

        String expectedJsonValue = mapper.writeValueAsString(track1);

        mockMvc.perform(delete("/trackRecommendations/1")) //Act
                .andDo(print())
                .andExpect(status().isNoContent());
    }


}