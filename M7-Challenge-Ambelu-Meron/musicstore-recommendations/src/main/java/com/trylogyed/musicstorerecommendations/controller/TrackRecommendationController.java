package com.trylogyed.musicstorerecommendations.controller;

import com.trylogyed.musicstorerecommendations.model.TrackRecommendation;
import com.trylogyed.musicstorerecommendations.repsitory.TrackRecommendationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class TrackRecommendationController {
    @Autowired
    TrackRecommendationRepo trackRecommendationRepo;

    @GetMapping("/trackRecommendations")
    public List<TrackRecommendation> getAllTrackRecommendations() {
        return trackRecommendationRepo.findAll();
    }

    @GetMapping("/trackRecommendations/{id}")
    public TrackRecommendation getTrackRecommendationById(@PathVariable Integer id) {
        return trackRecommendationRepo.findById(id).get();
    }

    @PostMapping("/trackRecommendations")
    @ResponseStatus(HttpStatus.CREATED)
    public TrackRecommendation createTrackRecommendation(@RequestBody TrackRecommendation rec) {
        return trackRecommendationRepo.save(rec);
    }



    @PutMapping("/trackRecommendations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrackRecommendation(@RequestBody TrackRecommendation rec) {

        trackRecommendationRepo.save(rec);
    }

    @DeleteMapping("/trackRecommendations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrackRecommendation(@PathVariable Integer id) {
        Optional<TrackRecommendation> trackToDelete = trackRecommendationRepo.findById(id);
        if (trackToDelete.isPresent() == false) {
            throw new IllegalArgumentException("No track with the id " + id);
        }
        trackRecommendationRepo.deleteById(id);
    }
}



