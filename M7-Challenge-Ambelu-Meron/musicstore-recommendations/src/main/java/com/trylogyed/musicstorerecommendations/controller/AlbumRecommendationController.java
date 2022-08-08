package com.trylogyed.musicstorerecommendations.controller;

import com.trylogyed.musicstorerecommendations.model.AlbumRecommendation;
import com.trylogyed.musicstorerecommendations.repsitory.AlbumRecommendationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class AlbumRecommendationController {
    @Autowired
    AlbumRecommendationRepo albumRecommendationRepo;

    @GetMapping("/albumRecommendations")
    public List<AlbumRecommendation> getAlbumRecommendations() {
        return albumRecommendationRepo.findAll();
    }

    @GetMapping("/albumRecommendations/{id}")
    public AlbumRecommendation getAlbumRecommendationById(@PathVariable Integer id) {
        return albumRecommendationRepo.findById(id).get();
    }

    @PostMapping("/albumRecommendations")
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumRecommendation createAlbumRecommendation(@RequestBody AlbumRecommendation rec) {
        return albumRecommendationRepo.save(rec);
    }



    @PutMapping("/albumRecommendations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbumRecommendation(@RequestBody AlbumRecommendation album) {

        albumRecommendationRepo.save(album);
    }

    @DeleteMapping("/albumRecommendations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbumRecommendation(@PathVariable Integer id) {
        Optional<AlbumRecommendation> albumToDelete = albumRecommendationRepo.findById(id);
        if (albumToDelete.isPresent() == false) {
            throw new IllegalArgumentException("No album with the id " + id);
        }
        albumRecommendationRepo.deleteById(id);
    }
}
