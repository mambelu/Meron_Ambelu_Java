package com.trylogyed.musicstorecatalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trylogyed.musicstorecatalog.model.Album;
import com.trylogyed.musicstorecatalog.repository.AlbumRepository;
import javassist.NotFoundException;
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

import java.math.BigDecimal;
import java.time.LocalDate;
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
@WebMvcTest(AlbumController.class)

public class AlbumControllerTest {
  @Autowired
    MockMvc mockMvc;

    @MockBean
    AlbumRepository albumRepo;

    ObjectMapper mapper = new ObjectMapper();

    private Album testAlbum;
    private List<Album> allAlbums = new ArrayList<>();
    private String albumJson;
    private String allAlbumsJson;

    @Before
    public void setup() throws Exception {
        setUpAlbumMock();
    }

    public void setUpAlbumMock() {
        Album testAlbum1 = new Album("Meron",3,LocalDate.ofEpochDay(2021 - 10 - 22),4,new BigDecimal("9.99"));
        Album testAlbum2 = new Album(2,"Meron",3,LocalDate.ofEpochDay(2021 - 10 - 22),4,new BigDecimal("14.99"));
        Album testAlbum3 = new Album(3,"Edom",4,LocalDate.ofEpochDay(2021 - 11 - 20),4,new BigDecimal("10.99"));
        List<Album> albumList = new ArrayList<>();

        albumList.add(testAlbum1);
        albumList.add(testAlbum2);



    }

    @Test
    public void shouldCreateAlbum() throws Exception {
        Album inputAlbum = new Album("Meron",3,LocalDate.ofEpochDay(2021 - 10 - 22),4,new BigDecimal("9.99"));
        Album outputAlbum = new Album(1,"Meron",3,LocalDate.ofEpochDay(2021 - 10 - 22),4,new BigDecimal("9.99"));


        String outputJson = mapper.writeValueAsString(outputAlbum);
        String inputJson = mapper.writeValueAsString(inputAlbum);

        doReturn(outputAlbum).when(albumRepo).save(inputAlbum);

        mockMvc.perform(post("/albums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(outputJson));



    }

    @Test
    public void shouldReturnAllAlbums() throws Exception {
        List<Album> albumList = new ArrayList<>();

        Album album1 = new Album();
        album1.setId(1);
        album1.setTitle("last day");
        album1.setLabelId(1);
        album1.setArtistId(1);
        album1.setListPrice(new BigDecimal("14.99"));
        album1.setReleaseDate(LocalDate.ofEpochDay(2021 - 10 - 22));

        Album album2 = new Album();
        album2.setId(2);
        album2.setTitle("kind of");
        album2.setLabelId(1);
        album2.setArtistId(2);
        album2.setListPrice(new BigDecimal("21.99"));
        album2.setReleaseDate(LocalDate.ofEpochDay(2021 - 10 - 31));

        albumList.add(album1);
        albumList.add(album2);

        doReturn(albumList).when(albumRepo).findAll();

        String expectedJsonValue = mapper.writeValueAsString(albumList);

        mockMvc.perform(get("/albums"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJsonValue));

    }




    @Test
    public void shouldUpdateAlbum() throws Exception {

        Album inputAlbum = new Album();
        inputAlbum.setId(1);
        inputAlbum.setTitle("one love");
        inputAlbum.setLabelId(1);
        inputAlbum.setArtistId(2);
        inputAlbum.setListPrice(new BigDecimal("21.99"));
        inputAlbum.setReleaseDate(LocalDate.ofEpochDay(2021 - 10 - 31));

        Album outputAlbum = new Album();
        outputAlbum.setId(1);
        outputAlbum.setTitle("one love updated");
        outputAlbum.setLabelId(1);
        outputAlbum.setArtistId(2);
        outputAlbum.setListPrice(new BigDecimal("21.99"));
        outputAlbum.setReleaseDate(LocalDate.ofEpochDay(2021 - 10 - 31));

        String inputJson = mapper.writeValueAsString(inputAlbum);
        String outputJson = mapper.writeValueAsString(outputAlbum);

        when(albumRepo.save(inputAlbum)).thenReturn(outputAlbum);

        mockMvc.perform(
                        put("/album")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());

    }

    @Test
    public void ShouldFindAlbumByIdAndReturnStatus200() throws Exception {
        Album inputAlbum = new Album("Meron",3,LocalDate.ofEpochDay(2021 - 10 - 22),4,new BigDecimal("9.99"));

        Optional<Album> optionalInput = Optional.of(inputAlbum);
        when(albumRepo.findById(4)).thenReturn(optionalInput);
        String outputJson = mapper.writeValueAsString(inputAlbum);


        mockMvc.perform(get("/albums/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(outputJson));

    }

    @Test
    public void ShouldReturn404ErrorIfAlbumNotFound() throws Exception {
        Album lostAlbum = new Album();
        lostAlbum.setId(21);
        lostAlbum.setTitle("one love");
        lostAlbum.setLabelId(1);
        lostAlbum.setArtistId(2);
        lostAlbum.setListPrice(new BigDecimal("21.99"));
        lostAlbum.setReleaseDate(LocalDate.ofEpochDay(2021 - 10 - 31));

        Optional<Album> thisAlbum = Optional.of(lostAlbum);
        when(albumRepo.findById(21)).thenReturn(thisAlbum);
        String expectedJsonValue = mapper.writeValueAsString(lostAlbum);

        mockMvc.perform(get("/albums/12"))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    @Test
    public void ShouldDeleteAlbumByIdAndReturnStatus204() throws Exception {
        Album terribleAlbum = new Album();
        terribleAlbum.setId(22);
        terribleAlbum.setTitle("one love");
        terribleAlbum.setLabelId(1);
        terribleAlbum.setArtistId(2);
        terribleAlbum.setListPrice(new BigDecimal("21.99"));
        terribleAlbum.setReleaseDate(LocalDate.ofEpochDay(2021 - 10 - 31));

        Optional<Album> thisAlbum = Optional.of(terribleAlbum);
        when(albumRepo.findById(22)).thenReturn(thisAlbum);

        albumRepo.delete(terribleAlbum);
        Mockito.verify(albumRepo, times(1)).delete(terribleAlbum);

        String expectedJsonValue = mapper.writeValueAsString(terribleAlbum);

        mockMvc.perform(delete("/album/22")) //Act
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}