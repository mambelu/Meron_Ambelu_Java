package com.trylogyed.musicstorecatalog.controller;

import com.trylogyed.musicstorecatalog.model.Artist;
import com.trylogyed.musicstorecatalog.model.Track;
import com.trylogyed.musicstorecatalog.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrackController {
    @Autowired
    TrackRepository repo;

    @GetMapping("/tracks")
    @ResponseStatus(HttpStatus.OK)
    public List<Track> getTracks() {
        return repo.findAll();
    }

    @GetMapping("/tracks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Track getTrackById(@PathVariable int id) {
        Optional<Track> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/tracks")
    @ResponseStatus(HttpStatus.CREATED)
    public Track addTrack(@RequestBody Track track) {
        return repo.save(track);
    }

    @PutMapping("/track")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrack(@RequestBody Track track) {

        repo.save(track);
    }


    @DeleteMapping("/track/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrack(@PathVariable Integer id) {
        Optional<Track> TrackToDelete = repo.findById(id);
        if(TrackToDelete.isPresent() == false ){
            throw new IllegalArgumentException("No track with the id "+id);
        }
        repo.deleteById(id);
    }


}
