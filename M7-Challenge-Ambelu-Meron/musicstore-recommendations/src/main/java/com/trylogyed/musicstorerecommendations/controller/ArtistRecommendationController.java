package com.trylogyed.musicstorerecommendations.controller;

import com.trylogyed.musicstorerecommendations.model.ArtistRecommendation;
import com.trylogyed.musicstorerecommendations.repsitory.ArtistRecommendationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ArtistRecommendationController {

    @Autowired
    ArtistRecommendationRepo artistRecommendationRepo;

    @GetMapping("/artistRecommendations")
    public List<ArtistRecommendation> getArtistRecommendations() {
        return artistRecommendationRepo.findAll();
    }

    @GetMapping("/artistRecommendations/{id}")
    public ArtistRecommendation getArtistRecommendationById(@PathVariable Integer id) {
        return artistRecommendationRepo.findById(id).get();
    }

    @PostMapping("/artistRecommendations")
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistRecommendation createArtistRecommendation(@RequestBody ArtistRecommendation rec) {
        return artistRecommendationRepo.save(rec);
    }



    @PutMapping("/artistRecommendations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtistRecommendation(@RequestBody ArtistRecommendation rec) {

        artistRecommendationRepo.save(rec);
    }

    @DeleteMapping("/artistRecommendations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtistRecommendation(@PathVariable Integer id) {
        Optional<ArtistRecommendation> recToDelete = artistRecommendationRepo.findById(id);
        if (recToDelete.isPresent() == false) {
            throw new IllegalArgumentException("No artist with the id " + id);
        }
        artistRecommendationRepo.deleteById(id);
    }
}


