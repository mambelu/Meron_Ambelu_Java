package com.trylogyed.musicstorerecommendations.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trylogyed.musicstorerecommendations.model.AlbumRecommendation;
import com.trylogyed.musicstorerecommendations.repsitory.AlbumRecommendationRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumRecommendationController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AlbumRecommendationControllerTest {
    @Autowired
    MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    AlbumRecommendationRepo albumRepo;

    private AlbumRecommendation album;


    @Before
    public void setup() throws Exception {
        setUpAlbumRecommendationMock();
    }

    public void setUpAlbumRecommendationMock() {
        album = new AlbumRecommendation();
        album.setAlbumId(1);
        album.setUserId(1);
        album.setLiked(true);

        AlbumRecommendation albumWithId = new AlbumRecommendation();
        albumWithId.setAlbumRecommendationId(1);
        albumWithId.setAlbumId(1);
        albumWithId.setUserId(1);
        albumWithId.setLiked(true);

        AlbumRecommendation otherAlbum = new AlbumRecommendation();
        otherAlbum.setAlbumRecommendationId(2);
        otherAlbum.setAlbumId(1);
        otherAlbum.setUserId(1);
        otherAlbum.setLiked(false);

        List<AlbumRecommendation> albumRecList = new ArrayList<>();
        albumRecList.add(albumWithId);
        albumRecList.add(otherAlbum);

        doReturn(albumRecList).when(albumRepo).findAll();
        doReturn(albumWithId).when(albumRepo).save(album);

    }

    @Test
    public void shouldCreateAlbumRecommendationAndReturnStatus201() throws Exception {
        album = new AlbumRecommendation();
        album.setAlbumId(1);
        album.setUserId(1);
        album.setLiked(true);

        AlbumRecommendation albumWithId = new AlbumRecommendation();
        albumWithId.setAlbumRecommendationId(1);
        albumWithId.setAlbumId(1);
        albumWithId.setUserId(1);
        albumWithId.setLiked(true);

        String outputJson = mapper.writeValueAsString(albumWithId);
        String inputJson = mapper.writeValueAsString(album);

        doReturn(albumWithId).when(albumRepo).save(album);

        mockMvc.perform(post("/albumRecommendations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));


    }

    @Test
    public void shouldReturnAllAlbumRecommendationsAndStatus200() throws Exception {
        AlbumRecommendation albumWithId = new AlbumRecommendation();
        albumWithId.setAlbumRecommendationId(1);
        albumWithId.setAlbumId(1);
        albumWithId.setUserId(1);
        albumWithId.setLiked(true);

        AlbumRecommendation otherAlbum = new AlbumRecommendation();
        otherAlbum.setAlbumRecommendationId(2);
        otherAlbum.setAlbumId(1);
        otherAlbum.setUserId(1);
        otherAlbum.setLiked(false);

        List<AlbumRecommendation> albumRecList = new ArrayList<>();
        albumRecList.add(albumWithId);
        albumRecList.add(otherAlbum);

        doReturn(albumRecList).when(albumRepo).findAll();

        String expectedJsonValue = mapper.writeValueAsString(albumRecList);

        mockMvc.perform(get("/albumRecommendations"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJsonValue));

    }


    @Test
    public void shouldUpdateAlbumRecommendationAndReturnStatus204() throws Exception {

        AlbumRecommendation inputAlbum = new AlbumRecommendation();
        inputAlbum.setAlbumRecommendationId(2);
        inputAlbum.setAlbumId(3);
        inputAlbum.setUserId(4);
        inputAlbum.setLiked(true);

        AlbumRecommendation outputAlbum = new AlbumRecommendation();
        outputAlbum.setAlbumRecommendationId(2);
        inputAlbum.setAlbumId(3);
        inputAlbum.setUserId(5);
        outputAlbum.setLiked(false);

        String inputJson = mapper.writeValueAsString(inputAlbum);
        String outputJson = mapper.writeValueAsString(outputAlbum);

        when(albumRepo.save(inputAlbum)).thenReturn(outputAlbum);

        mockMvc.perform(
                        put("/albumRecommendations")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }



    @Test
    public void ShouldFindAlbumRecommendationByIdAndReturnStatus200() throws Exception {

        AlbumRecommendation thisAlbum = new AlbumRecommendation();
        thisAlbum.setAlbumRecommendationId(2);
        thisAlbum.setAlbumId(5);
        thisAlbum.setUserId(8);
        thisAlbum.setLiked(false);

        Optional<AlbumRecommendation> found = Optional.of(thisAlbum);
        when(albumRepo.findById(2)).thenReturn(found);

        String expectedJsonValue = mapper.writeValueAsString(thisAlbum);

        mockMvc.perform(get("/albumRecommendations/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJsonValue));

    }

    @Test
    public void ShouldReturn422ErrorIfAlbumRecommendationNotFound() throws Exception {
        AlbumRecommendation thisAlbum = new AlbumRecommendation();
        thisAlbum.setAlbumRecommendationId(2);
        thisAlbum.setAlbumId(5);
        thisAlbum.setUserId(8);
        thisAlbum.setLiked(false);

        Optional<AlbumRecommendation> found = Optional.of(thisAlbum);
        when(albumRepo.findById(2)).thenReturn(found);

        String expectedJsonValue = mapper.writeValueAsString(thisAlbum);

        mockMvc.perform(get("/albumRecommendations/5"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }

    @Test
    public void ShouldDeleteAlbumRecommendationByIdAndReturnStatus204() throws Exception {
        AlbumRecommendation badRecommendation = new AlbumRecommendation();
        badRecommendation.setAlbumRecommendationId(12);
        badRecommendation.setAlbumId(5);
        badRecommendation.setUserId(8);
        badRecommendation.setLiked(true);

        Optional<AlbumRecommendation> found = Optional.of(badRecommendation);
        when(albumRepo.findById(12)).thenReturn(found);

        albumRepo.delete(badRecommendation);
        Mockito.verify(albumRepo, times(1)).delete(badRecommendation);

        String expectedJsonValue = mapper.writeValueAsString(badRecommendation);

        mockMvc.perform(delete("/albumRecommendations/12")) //Act
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void ShouldReturn422ErrorOnDeleteIfAlbumRecommendationNotExists() throws Exception {
        AlbumRecommendation badRecommendation = new AlbumRecommendation();
        badRecommendation.setAlbumRecommendationId(12);
        badRecommendation.setAlbumId(5);
        badRecommendation.setUserId(8);
        badRecommendation.setLiked(true);

        Optional<AlbumRecommendation> found = Optional.of(badRecommendation);
        when(albumRepo.findById(12)).thenReturn(found);

        albumRepo.delete(badRecommendation);
        Mockito.verify(albumRepo, times(1)).delete(badRecommendation);

        String expectedJsonValue = mapper.writeValueAsString(badRecommendation);

        mockMvc.perform(delete("/albumRecommendations/32")) //Act
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}