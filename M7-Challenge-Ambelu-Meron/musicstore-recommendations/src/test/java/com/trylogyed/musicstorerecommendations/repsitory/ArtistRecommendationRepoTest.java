package com.trylogyed.musicstorerecommendations.repsitory;

import com.trylogyed.musicstorerecommendations.model.ArtistRecommendation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class ArtistRecommendationRepoTest {

    @Autowired
    ArtistRecommendationRepo repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void addGetDeleteArtistRecommendation() {

        ArtistRecommendation artist = new ArtistRecommendation();
        artist.setArtistId(1);
        artist.setUserId(1);
        artist.setLiked(true);

        artist = repo.save(artist);

        Optional<ArtistRecommendation> found = repo.findById(artist.getArtistRecommendationId());

        assertEquals(found.get(), artist);

        repo.deleteById(artist.getArtistRecommendationId());

        found = repo.findById(artist.getArtistRecommendationId());

        assertFalse(found.isPresent());
    }

    @Test
    public void updateArtistRecommendation() {

        ArtistRecommendation artist = new ArtistRecommendation();
        artist.setArtistRecommendationId(1);
        artist.setArtistId(1);
        artist.setUserId(1);
        artist.setLiked(true);

        artist = repo.save(artist);

        ArtistRecommendation updated = new ArtistRecommendation();
        updated.setArtistRecommendationId(1);
        updated.setArtistId(1);
        updated.setUserId(1);
        updated.setLiked(false);

        updated = repo.save(artist);

        Optional<ArtistRecommendation> found = repo.findById(updated.getArtistRecommendationId());
        assertEquals(found.get(), artist);
    }

    @Test
    public void getAllArtistRecommendations() {

        ArtistRecommendation artist1 = new ArtistRecommendation();
        artist1.setArtistRecommendationId(1);
        artist1.setArtistId(1);
        artist1.setUserId(1);
        artist1.setLiked(true);

        repo.save(artist1);

        ArtistRecommendation artist2 = new ArtistRecommendation();
        artist2.setArtistRecommendationId(2);
        artist2.setArtistId(2);
        artist2.setUserId(2);
        artist2.setLiked(false);

        repo.save(artist2);

        List<ArtistRecommendation> aList = repo.findAll();
        assertEquals(aList.size(), 2);

    }


}